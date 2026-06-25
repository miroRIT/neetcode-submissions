-- Write your query below
Select name from customers where name not in (select customers.name from orders inner join customers on orders.customer_id = customers.id)