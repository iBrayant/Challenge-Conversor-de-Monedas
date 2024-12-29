package com.conversor.model;

import java.util.Map;

public class ExchangeRateResponse {
    private String result;
    private String documentation;
    private String terms_of_use;
    private long time_last_update_unix;
    private String time_last_update_utc;
    private long time_next_update_unix;
    private String time_next_update_utc;
    private String base_code;
    private Map<String, Double> conversion_rates;

    // Getters
    public String getResult() { return result; }
    public String getBaseCode() { return base_code; }
    public Map<String, Double> getConversionRates() { return conversion_rates; }
} 