SQL Queries

-- 1. Display snum, sname, city and comm of all salespeople.
SELECT snum, sname, city, comm FROM salespeople;

-- 2. Display all snum without duplicates from all orders.
SELECT DISTINCT snum FROM orders;

-- 3. Display names and commissions of all salespeople in London.
SELECT sname, comm FROM salespeople WHERE city = 'London';

-- 4. All customers with rating of 100.
SELECT * FROM cust WHERE rating = 100;

-- 5. Produce orderno, amount and date from all rows in the order table.
SELECT onum, amt, odate FROM orders;

-- 6. All customers in San Jose, who have rating more than 200.
SELECT * FROM cust WHERE city = 'San Jose' AND rating > 200;

-- 7. All customers who were either located in San Jose or had a rating above 200.
SELECT * FROM cust WHERE city = 'San Jose' OR rating > 200;

-- 8. All orders for more than $1000.
SELECT * FROM orders WHERE amt > 1000;

-- 9. Names and cities of all salespeople in London with commission above 0.10.
SELECT sname, city FROM salespeople WHERE city = 'London' AND comm > 0.10;

-- 10. All customers excluding those with rating <= 100 unless they are located in Rome.
SELECT * FROM cust WHERE rating > 100 OR city = 'Rome';

-- 11. All salespeople either in Barcelona or in London.
SELECT * FROM salespeople WHERE city IN ('Barcelona', 'London');

-- 12. All salespeople with commission between 0.10 and 0.12 (excluding boundaries).
SELECT * FROM salespeople WHERE comm > 0.10 AND comm < 0.12;

-- 13. All customers with NULL values in city column.
SELECT * FROM cust WHERE city IS NULL;

-- 14. All orders taken on Oct 3rd and Oct 4th 1994.
SELECT * FROM orders WHERE odate IN ('03-OCT-94', '04-OCT-94');

-- 15. All customers serviced by Peel or Motika.
SELECT * FROM cust WHERE snum IN (
    SELECT snum FROM salespeople WHERE sname IN ('Peel', 'Motika')
);

-- 16. All customers whose names begin with a letter from A to B.
SELECT * FROM cust WHERE cname LIKE 'A%' OR cname LIKE 'B%';

-- 17. All orders except those with 0 or NULL value in amt field.
SELECT * FROM orders WHERE amt IS NOT NULL AND amt <> 0;

-- 18. Count the number of salespeople currently listing orders in the order table.
SELECT COUNT(DISTINCT snum) AS active_salespeople FROM orders;

-- 19. Largest order taken by each salesperson, datewise.
SELECT snum, odate, MAX(amt) AS max_amt
FROM orders
GROUP BY snum, odate;

-- 20. Largest order taken by each salesperson with order value more than $3000.
SELECT snum, MAX(amt) AS max_amt
FROM orders
WHERE amt > 3000
GROUP BY snum;

-- 21. Which day had the highest total amount ordered.
SELECT odate, SUM(amt) AS total_amt
FROM orders
GROUP BY odate
ORDER BY total_amt DESC
LIMIT 1;

-- 22. Count all orders for Oct 3rd.
SELECT COUNT(*) AS total_orders FROM orders WHERE odate = '03-OCT-94';

-- 23. Count the number of different non NULL city values in customers table.
SELECT COUNT(DISTINCT city) AS unique_cities FROM cust WHERE city IS NOT NULL;

-- 24. Select each customer’s smallest order.
SELECT cnum, MIN(amt) AS min_amt
FROM orders
GROUP BY cnum;

-- 25. First customer in alphabetical order whose name begins with G.
SELECT * FROM cust WHERE cname LIKE 'G%' ORDER BY cname ASC LIMIT 1;

-- 26. Get the output like “For dd/mm/yy there are ___ orders.”
SELECT odate, COUNT(*) AS total_orders
FROM orders
GROUP BY odate;

-- 27. Assume each salesperson has a 12% commission. Produce order no., salesperson no., and amount of salesperson’s commission for that order.
SELECT onum, snum, amt * 0.12 AS commission FROM orders;

-- 28. Find highest rating in each city. Format: For the city (city), the highest rating is : (rating).
SELECT city, MAX(rating) AS max_rating
FROM cust
GROUP BY city;

-- 29. Display the totals of orders for each day and place the results in descending order.
SELECT odate, SUM(amt) AS total_amt
FROM orders
GROUP BY odate
ORDER BY total_amt DESC;

-- 30. All combinations of salespeople and customers who shared a city.
SELECT s.sname, c.cname, s.city
FROM salespeople s
JOIN cust c ON s.city = c.city;

-- 31. Name of all customers matched with the salespeople serving them.
SELECT c.cname, s.sname
FROM cust c
JOIN salespeople s ON c.snum = s.snum;

-- 32. List each order number followed by the name of the customer who made the order.
SELECT o.onum, c.cname
FROM orders o
JOIN cust c ON o.cnum = c.cnum;

-- 33. Names of salesperson and customer for each order after the order number.
SELECT o.onum, s.sname, c.cname
FROM orders o
JOIN salespeople s ON o.snum = s.snum
JOIN cust c ON o.cnum = c.cnum;

-- 34. Produce all customers serviced by salespeople with a commission above 12%.
SELECT * FROM cust
WHERE snum IN (SELECT snum FROM salespeople WHERE comm > 0.12);

-- 35. Calculate amount of the salesperson’s commission on each order with a rating above 100.
SELECT o.onum, o.amt * s.comm AS commission
FROM orders o
JOIN cust c ON o.cnum = c.cnum
JOIN salespeople s ON o.snum = s.snum
WHERE c.rating > 100;

-- 36. Find all pairs of customers having the same rating.
SELECT A.cname, B.cname, A.rating
FROM cust A, cust B
WHERE A.cnum < B.cnum AND A.rating = B.rating;

-- 37. Find all pairs of customers having the same rating, each pair coming once only.
-- Same as above
SELECT A.cname, B.cname, A.rating
FROM cust A, cust B
WHERE A.cnum < B.cnum AND A.rating = B.rating;

-- 38. Policy is to assign three salespeople to each customer. Display all such combinations.
SELECT c.cname, s1.sname, s2.sname, s3.sname
FROM cust c, salespeople s1, salespeople s2, salespeople s3
WHERE s1.snum < s2.snum AND s2.snum < s3.snum;

-- 39. All customers located in cities where salesman Serres has customers.
SELECT * FROM cust
WHERE city IN (
    SELECT city FROM cust WHERE snum = (
        SELECT snum FROM salespeople WHERE sname = 'Serres'
    )
);

-- 40. Find all pairs of customers served by single salesperson.
SELECT A.cname, B.cname
FROM cust A, cust B
WHERE A.snum = B.snum AND A.cnum < B.cnum;

-- 41. Produce all pairs of salespeople living in the same city (no self-pairs or duplicates).
SELECT A.sname, B.sname, A.city
FROM salespeople A, salespeople B
WHERE A.city = B.city AND A.snum < B.snum;

-- 42. Produce all pairs of orders by given customer, names that customers and eliminate duplicates.
SELECT A.onum, B.onum, C.cname
FROM orders A, orders B, cust C
WHERE A.cnum = B.cnum AND A.onum < B.onum AND A.cnum = C.cnum;

-- 43. Names and cities of all customers with the same rating as Hoffman.
SELECT cname, city FROM cust WHERE rating = (
    SELECT rating FROM cust WHERE cname = 'Hoffman'
);

-- 44. Extract all the orders of Motika.
SELECT * FROM orders
WHERE snum = (SELECT snum FROM salespeople WHERE sname = 'Motika');

-- 45. All orders credited to the same salesperson who services Hoffman.
SELECT * FROM orders
WHERE snum = (SELECT snum FROM cust WHERE cname = 'Hoffman');

-- 46. All orders that are greater than the average for Oct 4.
SELECT * FROM orders
WHERE odate = '04-OCT-94' AND amt > (
    SELECT AVG(amt) FROM orders WHERE odate = '04-OCT-94'
);

-- 47. Find average commission of salespeople in London.
SELECT AVG(comm) AS avg_comm
FROM salespeople
WHERE city = 'London';

-- 48. Find all orders attributed to salespeople servicing customers in London.
SELECT * FROM orders
WHERE snum IN (
    SELECT snum FROM cust WHERE city = 'London'
);

-- 49. Extract commissions of all salespeople servicing customers in London.
SELECT DISTINCT s.comm
FROM salespeople s
JOIN cust c ON s.snum = c.snum
WHERE c.city = 'London';

-- 50. Find all customers whose cnum is 1000 above the snum of Serres.
SELECT * FROM cust
WHERE cnum = (SELECT snum + 1000 FROM salespeople WHERE sname = 'Serres');

-- 51. Count the customers with rating above San Jose’s average.
SELECT COUNT(*) FROM cust
WHERE rating > (
    SELECT AVG(rating) FROM cust WHERE city = 'San Jose'
);

-- 52. Obtain all orders for the customer named Cisnerous.
SELECT * FROM orders
WHERE cnum = (SELECT cnum FROM cust WHERE cname = 'Cisnerous');

-- 53. Names and rating of all customers who have above average orders.
SELECT DISTINCT c.cname, c.rating
FROM cust c
JOIN orders o ON c.cnum = o.cnum
GROUP BY c.cname, c.rating
HAVING AVG(o.amt) > (SELECT AVG(amt) FROM orders);

-- 54. Total amount in orders for each salesperson > largest order in table.
SELECT snum, SUM(amt) AS total
FROM orders
GROUP BY snum
HAVING SUM(amt) > (SELECT MAX(amt) FROM orders);

-- 55. All customers with order on 3rd Oct.
SELECT DISTINCT c.* 
FROM cust c
JOIN orders o ON c.cnum = o.cnum
WHERE o.odate = '03-OCT-94';

-- 56. Names and numbers of all salesperson who have more than one customer.
SELECT s.snum, s.sname
FROM salespeople s
JOIN cust c ON s.snum = c.snum
GROUP BY s.snum, s.sname
HAVING COUNT(c.cnum) > 1;

-- 57. Check if the correct salesperson was credited with each sale.
SELECT o.onum, c.snum AS expected_snum, o.snum AS actual_snum
FROM orders o
JOIN cust c ON o.cnum = c.cnum
WHERE o.snum <> c.snum;

-- 58. All orders with above average amounts for their customers.
SELECT * FROM orders o
WHERE amt > (
    SELECT AVG(amt) FROM orders WHERE cnum = o.cnum
);

-- 59. Sums of orders grouped by date, eliminating where sum not at least 2000 above max amount.
SELECT odate, SUM(amt) AS total
FROM orders
GROUP BY odate
HAVING SUM(amt) >= (SELECT MAX(amt) FROM orders) + 2000;

-- 60. Customers with ratings equal to the maximum for their city.
SELECT * FROM cust c1
WHERE rating = (
    SELECT MAX(rating) FROM cust c2 WHERE c1.city = c2.city
);

-- 61. Salespeople who have customers in their cities who they don’t service.
-- Using JOIN
SELECT DISTINCT s.sname
FROM salespeople s
JOIN cust c ON s.city = c.city AND s.snum <> c.snum;

-- Using Correlated Subquery
SELECT s.sname FROM salespeople s
WHERE EXISTS (
    SELECT 1 FROM cust c WHERE s.city = c.city AND s.snum <> c.snum
);

-- 62. Extract cnum, cname, city if one or more customers are in San Jose.
SELECT cnum, cname, city FROM cust
WHERE EXISTS (SELECT 1 FROM cust WHERE city = 'San Jose');

-- 63. Salespeople no. who have multiple customers.
SELECT snum
FROM cust
GROUP BY snum
HAVING COUNT(cnum) > 1;

-- 64. Salespeople number, name and city who have multiple customers.
SELECT s.snum, s.sname, s.city
FROM salespeople s
JOIN cust c ON s.snum = c.snum
GROUP BY s.snum, s.sname, s.city
HAVING COUNT(c.cnum) > 1;

-- 65. Salespeople who serve only one customer.
SELECT s.snum, s.sname
FROM salespeople s
JOIN cust c ON s.snum = c.snum
GROUP BY s.snum, s.sname
HAVING COUNT(c.cnum) = 1;

-- 66. Salespeople with more than one current order.
SELECT s.snum, s.sname
FROM salespeople s
JOIN orders o ON s.snum = o.snum
GROUP BY s.snum, s.sname
HAVING COUNT(o.onum) > 1;

-- 67. Salespeople with customers with a rating of 300 (using EXISTS)
SELECT s.* FROM salespeople s
WHERE EXISTS (
    SELECT 1 FROM cust c WHERE c.snum = s.snum AND c.rating = 300
);

-- 68. Same as above (using JOIN)
SELECT DISTINCT s.*
FROM salespeople s
JOIN cust c ON s.snum = c.snum
WHERE c.rating = 300;

-- 69. Salespeople with customers in their city not assigned to them (using EXISTS)
SELECT s.* FROM salespeople s
WHERE EXISTS (
    SELECT 1 FROM cust c WHERE s.city = c.city AND c.snum <> s.snum
);

-- 70. Customers with salesperson who has at least one other customer with orders.
SELECT * FROM cust c1
WHERE EXISTS (
    SELECT 1 FROM cust c2
    JOIN orders o ON c2.cnum = o.cnum
    WHERE c1.snum = c2.snum AND c1.cnum <> c2.cnum
);

-- 71. Salespeople with customers in their cities (using ANY and IN)
SELECT * FROM salespeople
WHERE city = ANY (SELECT city FROM cust);

SELECT * FROM salespeople
WHERE city IN (SELECT city FROM cust);

-- 72. Salespeople for whom customers follow them alphabetically (ANY and EXISTS)
SELECT * FROM salespeople s
WHERE EXISTS (
    SELECT 1 FROM cust c WHERE c.sname > s.sname
);

-- 73. Customers with greater rating than any customer in Rome.
SELECT * FROM cust
WHERE rating > ANY (
    SELECT rating FROM cust WHERE city = 'Rome'
);

-- 74. Orders with amount greater than at least one order from Oct 6.
SELECT * FROM orders
WHERE amt > ANY (
    SELECT amt FROM orders WHERE odate = '06-OCT-94'
);

-- 75. Orders with amt < any amt for customer in San Jose.
SELECT * FROM orders
WHERE amt < ANY (
    SELECT amt FROM orders o2
    JOIN cust c2 ON o2.cnum = c2.cnum
    WHERE c2.city = 'San Jose'
);

-- 76. Customers with rating > every customer in Paris.
SELECT * FROM cust
WHERE rating > ALL (
    SELECT rating FROM cust WHERE city = 'Paris'
);

-- Using NOT EXISTS
SELECT * FROM cust c1
WHERE NOT EXISTS (
    SELECT 1 FROM cust c2
    WHERE c2.city = 'Paris' AND c1.rating <= c2.rating
);

-- 77. Customers with rating >= ANY of Serres’s customers.
SELECT * FROM cust
WHERE rating >= ANY (
    SELECT rating FROM cust WHERE snum = (
        SELECT snum FROM salespeople WHERE sname = 'Serres'
    )
);

-- 78. Salespeople with no customers in their city.
SELECT * FROM salespeople s
WHERE NOT EXISTS (
    SELECT 1 FROM cust c WHERE s.city = c.city
);

-- 79. Orders > any for customers in London.
SELECT * FROM orders
WHERE amt > ANY (
    SELECT amt FROM orders o2
    JOIN cust c2 ON o2.cnum = c2.cnum
    WHERE c2.city = 'London'
);

-- 80. All salespeople and customers located in London.
SELECT s.sname AS salesperson, c.cname AS customer
FROM salespeople s
JOIN cust c ON s.city = 'London' AND c.city = 'London';

-- 81. For every salesperson, dates on which highest and lowest orders were brought.
SELECT snum, odate, amt
FROM orders o1
WHERE amt = (
    SELECT MAX(amt) FROM orders o2 WHERE o1.snum = o2.snum
)
OR amt = (
    SELECT MIN(amt) FROM orders o2 WHERE o1.snum = o2.snum
);

-- 82. List all of the salespeople and indicate those who have/don’t have customers in their cities.
SELECT s.sname, s.city,
CASE 
    WHEN EXISTS (
        SELECT 1 FROM cust c WHERE c.city = s.city
    ) THEN 'Has customer'
    ELSE 'No customer'
END AS status
FROM salespeople s;

-- 83. Append strings to fields indicating if matched to customer in same city.
SELECT s.sname || ' - ' || 
    CASE 
        WHEN EXISTS (SELECT 1 FROM cust c WHERE c.city = s.city) 
        THEN 'MATCHED' ELSE 'UNMATCHED' 
    END AS result
FROM salespeople s;

-- 84. Union of queries with 'High Rating' or 'Low Rating' for customers.
SELECT cname, city, rating, 'High Rating' AS category
FROM cust WHERE rating >= 200
UNION
SELECT cname, city, rating, 'Low Rating'
FROM cust WHERE rating < 200;

-- 85. Name and number of each salesperson & customer with more than one current order (alphabetical).
SELECT sname, snum FROM salespeople WHERE snum IN (
    SELECT snum FROM orders GROUP BY snum HAVING COUNT(*) > 1
)
UNION
SELECT cname, cnum FROM cust WHERE cnum IN (
    SELECT cnum FROM orders GROUP BY cnum HAVING COUNT(*) > 1
)
ORDER BY sname;

-- 86. Name of salesperson with multiple customers and orders for more than one of them.
SELECT sname
FROM salespeople s
WHERE s.snum IN (
    SELECT c.snum FROM cust c
    JOIN orders o ON c.cnum = o.cnum
    GROUP BY c.snum, c.cnum
    HAVING COUNT(DISTINCT c.cnum) > 1
);

-- 87. Produce all the salesperson in London who had at least one customer there.
SELECT s.snum, s.sname, s.city
FROM salespeople s
WHERE s.city = 'London'
  AND s.snum IN (SELECT snum FROM cust WHERE city = 'London');

-- 88. Produce all the salesperson in London who did not have customers there.
SELECT s.snum, s.sname, s.city
FROM salespeople s
WHERE s.city = 'London'
  AND s.snum NOT IN (SELECT snum FROM cust WHERE city = 'London');

-- 89. We want to see salespeople matched to their customers without excluding those salespeople who were not currently assigned to any customers. (Use OUTER join and UNION)
-- Using LEFT JOIN:
SELECT s.snum, s.sname, c.cnum, c.cname
FROM salespeople s
LEFT JOIN cust c ON s.snum = c.snum
UNION
SELECT s.snum, s.sname, c.cnum, c.cname
FROM salespeople s
RIGHT JOIN cust c ON s.snum = c.snum
ORDER BY s.snum;

