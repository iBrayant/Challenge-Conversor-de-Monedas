# Conversor de Monedas

![Java](https://img.shields.io/badge/Java-11+-ED8B00?logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apachemaven&logoColor=white)
![Gson](https://img.shields.io/badge/Gson-2.10.1-4285F4)
![Licencia](https://img.shields.io/badge/licencia-MIT-green)

Aplicación de consola en Java que convierte cantidades entre monedas con tasas de cambio actualizadas, consultadas a la API de [ExchangeRate-API](https://www.exchangerate-api.com/).

> Challenge **Conversor de Monedas** del programa Oracle Next Education (Alura Latam), Back-end.

<!-- TODO: captura de la consola (guardar en docs/img/) -->
<!-- ![Consola](docs/img/consola.png) -->

## Características

- **Conversión entre cualquier par de monedas** que soporte la API (más de 160): escribes el código de origen, el de destino y la cantidad.
- **Listado de monedas disponibles**, ordenado alfabéticamente.
- **Tasas en tiempo real:** cada conversión consulta las tasas de la moneda de origen.
- **Validación de la entrada:** rechaza opciones no numéricas, cantidades negativas o inválidas, y monedas vacías o no soportadas.
- Cliente HTTP nativo (`java.net.http`) y Gson para leer la respuesta.

## Stack

Java 11 · Maven · Gson · `java.net.http.HttpClient` · ExchangeRate-API

## Estructura

```
src/main/java/com/conversor/
├── Main.java                     -> menú de consola
├── service/ConversorService      -> consulta a la API y cálculo de la conversión
└── model/ExchangeRateResponse    -> respuesta de la API
```

## Cómo correrlo

Requisitos: Java 11+ y Maven.

1. Obtén una clave gratuita en [exchangerate-api.com](https://www.exchangerate-api.com/) y defínela como variable de entorno. La aplicación no arranca sin ella:

   ```bash
   export EXCHANGERATE_API_KEY="tu_clave"
   ```

2. Ejecuta:

   ```bash
   mvn exec:java
   ```

   O genera el JAR ejecutable y córrelo:

   ```bash
   mvn clean package
   java -jar target/conversor-monedas-1.0-SNAPSHOT.jar
   ```

## Uso

```
=== Conversor de Monedas ===
1. Realizar conversión
2. Ver monedas disponibles
0. Salir
```

Ejemplo de conversión:

```
Ingrese la moneda de origen (ejemplo: USD): USD
Ingrese la moneda de destino (ejemplo: EUR): COP
Ingrese la cantidad a convertir: 100
100.00 USD = 400000.00 COP
```

(El resultado depende de la tasa del momento.)

## Autor

**Brayant Vásquez Gómez** · [GitHub](https://github.com/iBrayant) · [LinkedIn](https://www.linkedin.com/in/brayant-v%C3%A1squez-g%C3%B3mez-4b483a1a1)

Licencia [MIT](LICENSE).
