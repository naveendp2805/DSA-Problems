# Write your MySQL query statement below
SELECT
    person_name
FROM (
    SELECT
        person_name,
        SUM(weight) OVER(ORDER BY turn) AS running_sum
    FROM Queue
) AS t
WHERE t.running_sum <= 1000
ORDER BY t.running_sum DESC
LIMIT 1;