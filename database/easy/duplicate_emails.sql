-- https://leetcode.com/problems/duplicate-emails/

SELECT email
FROM person
GROUP BY email
HAVING COUNT(id) > 1;
