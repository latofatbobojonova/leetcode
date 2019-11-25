-- https://leetcode.com/problems/not-boring-movies/

SELECT *
FROM cinema
WHERE id % 2 = 1
  AND NOT description = 'boring'
ORDER BY rating DESC