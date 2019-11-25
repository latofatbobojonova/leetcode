--  https://leetcode.com/problems/combine-two-tables/

SELECT p.firstname, p.lastname, a.city, a.state
from person p
         left join address a on p.personid = a.personid