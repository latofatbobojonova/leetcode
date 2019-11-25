-- https://leetcode.com/problems/rising-temperature/

SELECT t1.id
FROM weather t1
         INNER JOIN
     weather t2 ON DATE_SUB(t1.recorddate, INTERVAL 1 DAY) = t2.recorddate
WHERE t1.temperature > t2.temperature;