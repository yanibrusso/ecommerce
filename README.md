# Api Ecommerce

Aplicacion para consultar precios de distintas cadenas_


### Pre-requisitos 📋

_Que cosas necesitas para instalar el software

```
JAVA 1.8 
MAVEN 2.6.2 
```
## Ejecutando las pruebas ⚙️

Coleccion de postman con todos los casos de prueba adjuntada

```
http://localhost:8080/v1/price?date=2020-06-14T10:00:00&productId=35455&brandId=1
http://localhost:8080/v1/price?date=2020-06-14T16:00:00&productId=35455&brandId=1
http://localhost:8080/v1/price?date=2020-06-14T21:00:00&productId=35455&brandId=1
http://localhost:8080/v1/price?date=2020-06-15T10:00:00&productId=35455&brandId=1
http://localhost:8080/v1/price?date=2020-12-31 23:59:59&productId=111&brandId=1
http://localhost:8080/v1/price?date=fecha&productId=35455&brandId=1

```

## Construido con 🛠️



H2 ; 
JAVA 1.8 ;
SPRING BOOT ;
FLIWAY

## Consigna 📄

Se pide:

Construir una aplicación/servicio en SpringBoot que provea una end point rest de consulta  tal que:

Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.

Se debe utilizar una base de datos en memoria (tipo h2) e inicializar con los datos del ejemplo, (se pueden cambiar el nombre de los campos y añadir otros nuevos si se quiere, elegir el tipo de dato que se considere adecuado para los mismos).

Desarrollar unos test al endpoint rest que  validen las siguientes peticiones al servicio con los datos del ejemplo:

-          Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
-          Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)


Se valorará:

Diseño y construcción del servicio.
Calidad de Código.
Resultados correctos en los test.