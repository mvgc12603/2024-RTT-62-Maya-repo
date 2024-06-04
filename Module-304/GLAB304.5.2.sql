SELECT customername, country, creditLimit
FROM customers
WHERE (country = 'USA' OR country = 'France') AND
creditlimit > 100000;

SELECT productCode, productName, buyPrice
FROM products
WHERE buyPrice BETWEEN 90 AND 100;
-- Same as:
-- WHERE buyPrice >= 90 AND buyPrice <= 100;
-- can also use NOT BETWEEN

SELECT c.customerNumber, c.customerName, orderNumber,
o.STATUS
FROM customers c
LEFT JOIN orders o
ON c.customerNumber = o.customerNumber
WHERE orderNumber IS NULL;