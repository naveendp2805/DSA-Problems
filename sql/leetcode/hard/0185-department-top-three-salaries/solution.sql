# Write your MySQL query statement below
WITH dept_ranking AS (
    SELECT
        d.name AS Department,
        e.name AS Employee,
        e.salary AS Salary,
        DENSE_RANK() OVER(PARTITION BY d.name ORDER BY e.salary DESC) as ranking
    FROM Employee e
    JOIN Department d
        ON e.departmentId = d.id
)
SELECT
    Department,
    Employee,
    Salary
FROM dept_ranking
WHERE ranking <= 3;
