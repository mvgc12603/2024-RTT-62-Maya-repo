SELECT order_id, SUM(quantity_Ordered) as Qty,
IF(MOD(SUM(quantity_Ordered),2),'Odd', 'Even') as oddOrEven
FROM orderdetails
GROUP BY order_id
ORDER BY order_id;

SELECT TRUNCATE(1.2345,1);

SELECT product_id, ROUND(AVG(quantity_Ordered * price_Each)) as avg_order_value
FROM orderDetails
GROUP BY product_id;

UPDATE products
SET product_Description = REPLACE(product_Description,'abuot','about');

select product_Description
from products;


SELECT DATEDIFF('2011-08-17','2011-08-17');
#Result : 0 days
SELECT DATEDIFF('2011-08-17','2011-08-08');
#Result: 9 days
SELECT DATEDIFF('2011-08-08','2011-08-17');
#Result: -9 days

SELECT id, DATEDIFF(required_Date, shipped_Date) as days_Left
FROM orders
WHERE DATEDIFF(required_Date, shipped_Date) >=0
ORDER BY  days_Left ASC;


SELECT
    id,
    COALESCE(
    CASE
        WHEN DATEDIFF(required_Date, shipped_Date) > 0 
        THEN DATEDIFF(required_Date, shipped_Date)
    END, 'None') AS days_Left,
	COALESCE(
    CASE
        WHEN DATEDIFF(required_Date, shipped_Date) <= 0 THEN DATEDIFF(required_Date, shipped_Date)
        ELSE NULL
    END, 'Not') AS URGENT
FROM orders
WHERE DATEDIFF(required_Date, shipped_Date) IS NOT NULL
ORDER BY URGENT ASC, days_Left ASC;


SELECT
Id,
ROUND(DATEDIFF(required_Date, order_Date) / 7, 2) Weeks,
ROUND(DATEDIFF(required_Date, order_Date) / 30,2) Months
FROM orders
WHERE status = 'In Process';

SELECT
Id,
DATE_FORMAT(order_Date,  '%b %e, %Y') order_Date,
DATE_FORMAT(required_Date, '%W, %M %D %Y') required_Date,
DATE_FORMAT(shipped_Date, '%W, %M %D %Y') shipped_Date
FROM orders
ORDER BY required_Date;

SELECT LPAD('hi',4,'??'); #Result -> '??hi'
SELECT LPAD('hi',1,'??'); # Result -> 'h'
SELECT firstName, LPAD(firstName,10,'kk'), LPAD(firstName,5,'kk'),
LPAD(firstName,4,'kk') FROM classic_models.employees;

SELECT TRIM(' SQL TRIM Function ');
SELECT RTRIM(' SQL LTRIM function');


SELECT YEAR(shipped_date) as Year, COUNT(id) as
OrderQty
FROM orders
GROUP BY YEAR(shipped_date)
ORDER BY YEAR(shipped_date);

SELECT DAY(order_date) as dayofmonth, COUNT(*)
-- Same as DAYOFMONTH()
FROM orders WHERE YEAR(order_date) = 2004
GROUP BY dayofmonth
ORDER BY dayofmonth;