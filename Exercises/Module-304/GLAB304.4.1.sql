SELECT
order_id,
order_Line_Number,
quantity_Ordered * price_Each AS subtotal
FROM orderdetails
ORDER BY subtotal DESC;

SELECT firstName, lastName, reports_To
FROM employees
ORDER BY reports_To DESC;