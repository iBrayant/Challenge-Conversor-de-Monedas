package com.conversor;

import com.conversor.service.ConversorService;
import java.util.Scanner;
import java.util.Set;
import java.util.InputMismatchException;

public class Main {
    private static final String API_KEY = "7383ba13c7e8e0bdfcec3912";
    private static final Scanner scanner = new Scanner(System.in);
    private static final ConversorService conversor = new ConversorService(API_KEY);

    public static void main(String[] args) {
        while (true) {
            try {
                mostrarMenu();
                String input = scanner.nextLine().trim();
                
                if (input.isEmpty()) {
                    continue;
                }

                int opcion;
                try {
                    opcion = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingrese un número válido.");
                    continue;
                }

                switch (opcion) {
                    case 0:
                        System.out.println("¡Gracias por usar el conversor!");
                        scanner.close();
                        return;
                    case 1:
                        realizarConversion();
                        break;
                    case 2:
                        mostrarMonedasDisponibles();
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Presione Enter para continuar...");
                scanner.nextLine();
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n=== Conversor de Monedas ===");
        System.out.println("1. Realizar conversión");
        System.out.println("2. Ver monedas disponibles");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void mostrarMonedasDisponibles() throws Exception {
        Set<String> monedas = conversor.obtenerMonedasDisponibles();
        System.out.println("\nMonedas disponibles:");
        System.out.println("====================");
        int contador = 0;
        for (String moneda : monedas) {
            System.out.print(String.format("%-4s", moneda));
            contador++;
            if (contador % 10 == 0) {
                System.out.println();
            }
        }
        if (contador % 10 != 0) {
            System.out.println();
        }
        System.out.println();
    }

    private static void realizarConversion() throws Exception {
        System.out.print("Ingrese la moneda de origen (ejemplo: USD): ");
        String monedaOrigen = scanner.nextLine().toUpperCase().trim();

        if (monedaOrigen.isEmpty()) {
            throw new IllegalArgumentException("La moneda de origen no puede estar vacía.");
        }

        System.out.print("Ingrese la moneda de destino (ejemplo: EUR): ");
        String monedaDestino = scanner.nextLine().toUpperCase().trim();

        if (monedaDestino.isEmpty()) {
            throw new IllegalArgumentException("La moneda de destino no puede estar vacía.");
        }

        System.out.print("Ingrese la cantidad a convertir: ");
        double cantidad;
        try {
            cantidad = Double.parseDouble(scanner.nextLine().trim());
            if (cantidad < 0) {
                throw new IllegalArgumentException("La cantidad no puede ser negativa.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Por favor, ingrese un número válido.");
        }

        double resultado = conversor.convertir(monedaOrigen, monedaDestino, cantidad);
        
        System.out.printf("%.2f %s = %.2f %s%n", 
            cantidad, monedaOrigen, resultado, monedaDestino);
    }
} 