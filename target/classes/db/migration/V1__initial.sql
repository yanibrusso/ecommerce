
CREATE TABLE BRANDS(
      ID INT,
      BRAND_NAME VARCHAR(20) NOT NULL,
      PRIMARY KEY (ID)
);

CREATE TABLE PRICE(
      ID INT NOT NULL AUTO_INCREMENT,
      BRAND_ID INT NOT NULL,
      START_DATE DATETIME NOT NULL,
      END_DATE DATETIME NOT NULL,
      PRICE_LIST DOUBLE NOT NULL,
      PRODUCT_ID  INT NOT NULL,
      PRIORITY INT NOT NULL,
      PRICE DOUBLE NOT NULL,
      CURR VARCHAR(3) NOT NULL,
      PRIMARY KEY (ID)
);

INSERT INTO PRICE (BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES (1,'2020-06-14 00:00:00','2020-12-31 23:59:59',1,'35455',0,35.50,'EUR');
INSERT INTO PRICE (BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES (1,'2020-06-14 15:00:00','2020-06-14 18:30:00',2,'35455',1,25.45,'EUR');
INSERT INTO PRICE (BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES (1,'2020-06-15 00:00:00','2020-06-15 11:00:00',3,'35455',1,30.50,'EUR');
INSERT INTO PRICE (BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES (1,'2020-06-15 16:00:00','2020-12-31 23:59:59',4,'35455',1,38.95,'EUR');


INSERT INTO BRANDS (ID, BRAND_NAME) values (1,'ZARA');
INSERT INTO BRANDS (ID, BRAND_NAME) values (2,'H&M');
INSERT INTO BRANDS (ID, BRAND_NAME) values (3,'MANGO');
INSERT INTO BRANDS (ID, BRAND_NAME) values (4,'UMA');

ERT INTO PRICE  values (4,1,'2020-06-15 16.00.00','2020-12-31 23.59.59',4,35455,1,38.95,'EUR');