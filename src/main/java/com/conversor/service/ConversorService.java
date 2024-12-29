package com.conversor.service;

import com.conversor.model.ExchangeRateResponse;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ConversorService {
    private final String apiKey;
    private final String baseUrl;
    private final HttpClient httpClient;
    private final Gson gson;

    public ConversorService(String apiKey) {
        this.apiKey = apiKey;
        this.baseUrl = "https://v6.exchangerate-api.com/v6/" + apiKey;
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public Set<String> obtenerMonedasDisponibles() throws Exception {
        ExchangeRateResponse tasas = obtenerTasasDeCambio("USD");
        return new TreeSet<>(tasas.getConversionRates().keySet());
    }

    public ExchangeRateResponse obtenerTasasDeCambio(String monedaBase) throws Exception {
        String url = baseUrl + "/latest/" + monedaBase;
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        
        return gson.fromJson(response.body(), ExchangeRateResponse.class);
    }

    public double convertir(String monedaOrigen, String monedaDestino, double cantidad) throws Exception {
        ExchangeRateResponse tasas = obtenerTasasDeCambio(monedaOrigen);
        Map<String, Double> rates = tasas.getConversionRates();
        
        if (!rates.containsKey(monedaDestino)) {
            throw new IllegalArgumentException("Moneda de destino no soportada: " + monedaDestino);
        }
        
        return cantidad * rates.get(monedaDestino);
    }
} 