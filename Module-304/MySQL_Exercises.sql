-- Homework 1
-- Question 0.1
-- I want to see the count of the number of products in each product line
SELECT product_line AS ProductLine, 
	   COUNT(p.id) AS ProductsQty
FROM productlines pl, products p
WHERE pl.id = p.productline_id
GROUP BY pl.id
ORDER BY product_line;

-- question 0.2
-- I want to see a list of employees and all of the customers for that employee.   Employee name will be duplicated in the result set.   
-- I want to see the employee first and last name
-- and the customer contact first and last name as well as the customer name
SELECT 
	Firstname, 
    Lastname, 
    Contact_firstname, 
    Contact_lastname, 
    Customer_name
FROM employees e, customers c
WHERE e.id = c.sales_rep_employee_id
ORDER BY firstname;

-- question 0.3
-- I want to see a list of employees in each office.   Show the office name and the employee name
SELECT 
	o.id as Office, 
	Firstname, 
    Lastname
FROM employees e, offices o
WHERE o.id = e.office_id
ORDER BY LastName;

-- question 0.4
-- I want to see the total number of each employee type based on job title.. 
-- result should be the job title and the number of employess with that job title.
SELECT job_title AS Job, 
	   COUNT(job_title) AS EmployeeQty
FROM employees e
GROUP BY job_title
ORDER BY EmployeeQty DESC;

-- question 0.5
-- I want to see a list of all payments each customer has made.  
-- Order the list by customer name ascending, then by the payment amount descending
SELECT 
		c.id AS CustomerId, 
		c.customer_name AS Customer, 
		p.id AS PaymentId, 
        p.amount, 
        p.check_number AS CheckNum, 
        p.payment_date AS PaymentDate
FROM Customers c, Payments p
WHERE c.id = p.customer_id
ORDER BY c.customer_name, p.amount DESC;

-- question 0.6
-- I want to see a list of products that have never been sold.   
-- use ... not in ( select product_id from orderdetails ) in your where clause
-- select * from products where id not in ( select product_id from orderdetails ); 
	SELECT product_name AS Products_Never_Sold
    FROM products p
    WHERE p.id NOT IN
		(SELECT product_id 
        FROM orderdetails)
	ORDER BY product_name;
   
-- question 0.7
-- Are there any customers that have never made an order
	SELECT customer_name as Customers
    FROM customers c
    WHERE c.id NOT IN
		(SELECT customer_id 
        FROM orders)
	ORDER BY Customers;

-- Question 1
-- How many customers are handled by each office.  I want to see the office name and the count of the number of customers in that office.
SELECT 
	o.id AS OfficeId, 
	o.state AS OfficeState, 
    COUNT(c.id) AS CustomerCount
FROM offices o, customers c, employees e
WHERE o.id = e.office_id
	AND e.id = c.sales_rep_employee_id
GROUP BY o.id
ORDER BY o.id;

-- Question 2
-- I want to see the products with the most margin at the top of the table.  
-- Include the product name, buy price, msrp, and margin in the results.  Margin is calculated (MSPR - buy_price)
SELECT 
	p.product_name Product, 
	p.buy_price Price, 
    p.msrp MSRP, 
    (MSRP - buy_price) AS Margin
FROM products p
ORDER BY Margin;


-- Question 2.5
-- I want to see the top 5 customers in each state based on margin 

-- My code, returns all customers
SELECT c.state, c.customer_name, (MSRP - buy_price) AS ProfitMargin
FROM Customers c, Products p, Orderdetails od, Orders o
WHERE p.id = od.product_id 
	AND order_id = o.id
    AND customer_id = c.id
    AND country = 'USA'
ORDER BY State, Margin DESC;

-- AI generated code
WITH RankedCustomers AS (
    SELECT
        c.state,
        c.customer_name,
        (MSRP - buy_price) AS Margin,
        RANK() OVER (PARTITION BY c.state ORDER BY (MSRP - buy_price) DESC) AS CustomerRank
    FROM Orders o
    JOIN Orderdetails od ON o.id = od.order_id
    JOIN Products p ON od.product_id = p.id
    JOIN Customers c ON c.id = o.customer_id
    WHERE c.country = 'USA'
)
SELECT state, customer_name, Margin
FROM RankedCustomers
WHERE CustomerRank < 5
ORDER BY state, Margin DESC;

-- Question 3
--  I want to see the top 5 salesmen in the company based on the total amount sold

SELECT 
COUNT(e.id) SalesQty,
	e.id,
	Firstname, 
    Lastname
FROM employees e, customers c
WHERE e.id = c.sales_rep_employee_id
GROUP BY e.id
ORDER BY SalesQty DESC
LIMIT 5;

-- Question 4
-- I want to see the top 5 salesmen based on overall profit (margin)
return to question later
SELECT 
	e.id,
	Firstname, 
    Lastname,
    COUNT(p.amount) ProfitEarned
FROM employees e, payments p, customers c
WHERE e.id = c.sales_rep_employee_id
	AND c.id = p.customer_id
GROUP BY e.id
ORDER BY ProfitEarned DESC
LIMIT 5;

select e.id, p.amount
FROM employees e, payments p;

-- Question 5 
-- I want to see all of the orders that happened in 2004.   You can use a function called year(order_date) = 2004
SELECT order_date AS OrderDate, o.id AS Id, product_name AS Product
 FROM Orders o
    JOIN Orderdetails od ON o.id = od.order_id
    JOIN Products p ON od.product_id = p.id
WHERE year(order_date) = 2004
	AND status = 'Shipped'
ORDER BY order_date;

-- Question 6
-- I want to see the total amount of all orders grouped by the year
SELECT
    YEAR(o.order_date) AS OrderYear,
    COUNT(DISTINCT o.id) AS OrderQty,
    COUNT(DISTINCT CASE WHEN o.status = 'Shipped' THEN o.id END) AS ShippedOrdersQty
FROM orders o
JOIN orderdetails od ON o.id = od.order_id
GROUP BY YEAR(o.order_date);



-- Question 7
-- I want to see the top 5 products based on quantity sold across all orders
SELECT 
	p.product_name AS Products,
    SUM(quantity_ordered) AS Quantity
FROM 
	Products p,
    Orders o,
    OrderDetails od
WHERE 
	p.id = od.product_id
    AND od.order_id = o.id
    AND o.status != 'cancelled'
GROUP BY p.id
ORDER BY Quantity DESC
LIMIT 5;


-- question 7.5
-- how many times has each product appeared in an order reguardless of how many were purchased.
SELECT 
	p.product_name AS Products,
    COUNT(p.id) AS Quantity
FROM 
	Products p,
    OrderDetails od
WHERE 
	p.id = od.product_id
GROUP BY p.id
ORDER BY Quantity DESC;

-- question 7.6
-- how many products would be out of stock baed on the amount sold acrosss tiem.  -- not sure if the data will spoort this .. basically 
-- looking for any product where the sum of the quantity sold is greater than the quantity in stock


-- question 7.9
-- I want to see the distinct order status ordered alphabetically
SELECT DISTINCT status
FROM orders
ORDER BY status;

-- Question 8
-- I want to see the office name and the distinct product lines that have been sold in that office.  This will require joining almost all of the tables.  
-- select distinct o.name as office_name, pl.productlines as product_line_name  .... 
