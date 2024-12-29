# Conversor de Monedas - Challenge ONE Back End

Este es un conversor de monedas desarrollado en Java que permite realizar conversiones entre diferentes divisas utilizando tasas de cambio en tiempo real a través de la API de ExchangeRate. El proyecto forma parte del Challenge ONE Back End de Alura Latam.

## Requisitos Previos

- Java JDK 11 o superior
- Maven 3.6 o superior

## Instalación

1. Clona el repositorio:
```bash
git clone [URL_DEL_REPOSITORIO]
cd conversor-monedas
```

2. Compila el proyecto:
```bash
mvn clean package
```

## Ejecución

Hay dos formas de ejecutar la aplicación:

### Usando el archivo JAR

```bash
java -jar target/conversor-monedas-1.0-SNAPSHOT.jar
```

### Usando Maven

```bash
mvn exec:java
```

## Uso

1. Al iniciar la aplicación, se mostrará un menú con las siguientes opciones:
   - 1: Realizar conversión
   - 0: Salir

2. Para realizar una conversión:
   - Seleccione la opción 1
   - Ingrese la cantidad a convertir
   - Seleccione la moneda de origen
   - Seleccione la moneda de destino
   - El programa mostrará el resultado de la conversión

3. Para salir del programa, seleccione la opción 0

## Características

- Interfaz de línea de comandos fácil de usar
- Conversiones en tiempo real
- Soporte para múltiples monedas
- Utiliza la API de ExchangeRate para obtener tasas de cambio actualizadas

## Tecnologías Utilizadas

- Java 11
- Maven
- Gson (para manejo de JSON)
- API de ExchangeRate
