-- https://leetcode.com/problems/customers-who-never-order/

select name as Customers
from customers
where id not in (select customerid from orders);


-- solution with JOIN and IS NULL (slower)
select name as Customers
from orders o
         right join customers c
                    on o.customerid = c.id
where o.customerid is null;
