-- https://leetcode.com/problems/reformat-department-table/

SELECT id,
       SUM(jan)  AS Jan_Revenue,
       SUM(feb)  AS Feb_Revenue,
       SUM(mar)  AS Mar_Revenue,
       SUM(apr)  AS Apr_Revenue,
       SUM(may)  AS May_Revenue,
       SUM(jun)  AS Jun_Revenue,
       SUM(jul)  AS Jul_Revenue,
       SUM(aug)  AS Aug_Revenue,
       SUM(sep)  AS Sep_Revenue,
       SUM(oct)  AS Oct_Revenue,
       SUM(nov)  AS Nov_Revenue,
       SUM(decm) AS Dec_Revenue
FROM (
         SELECT id,
                CASE WHEN month = 'Jan' THEN revenue END AS jan,
                CASE WHEN month = 'Feb' THEN revenue END AS feb,
                CASE WHEN month = 'Mar' THEN revenue END AS mar,
                CASE WHEN month = 'Apr' THEN revenue END AS apr,
                CASE WHEN month = 'May' THEN revenue END AS may,
                CASE WHEN month = 'Jun' THEN revenue END AS jun,
                CASE WHEN month = 'Jul' THEN revenue END AS jul,
                CASE WHEN month = 'Aug' THEN revenue END AS aug,
                CASE WHEN month = 'Sep' THEN revenue END AS sep,
                CASE WHEN month = 'Oct' THEN revenue END AS oct,
                CASE WHEN month = 'Nov' THEN revenue END AS nov,
                CASE WHEN month = 'Dec' THEN revenue END AS decm
         FROM department
     ) AS X
GROUP BY id
ORDER BY id;

-- Shorter but slower solution
SELECT id,
       SUM(CASE WHEN month = 'Jan' THEN revenue END) AS Jan_Revenue,
       SUM(CASE WHEN month = 'Feb' THEN revenue END) AS Feb_Revenue,
       SUM(CASE WHEN month = 'Mar' THEN revenue END) AS Mar_Revenue,
       SUM(CASE WHEN month = 'Apr' THEN revenue END) AS Apr_Revenue,
       SUM(CASE WHEN month = 'May' THEN revenue END) AS May_Revenue,
       SUM(CASE WHEN month = 'Jun' THEN revenue END) AS Jun_Revenue,
       SUM(CASE WHEN month = 'Jul' THEN revenue END) AS Jul_Revenue,
       SUM(CASE WHEN month = 'Aug' THEN revenue END) AS Aug_Revenue,
       SUM(CASE WHEN month = 'Sep' THEN revenue END) AS Sep_Revenue,
       SUM(CASE WHEN month = 'Oct' THEN revenue END) AS Oct_Revenue,
       SUM(CASE WHEN month = 'Nov' THEN revenue END) AS Nov_Revenue,
       SUM(CASE WHEN month = 'Dec' THEN revenue END) AS Dec_Revenue
FROM department
GROUP BY id
ORDER BY id;
