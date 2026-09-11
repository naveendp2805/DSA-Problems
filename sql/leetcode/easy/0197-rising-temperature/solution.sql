# Write your MySQL query statement below
SELECT
    id 
FROM (
    SELECT
        id,
        recordDate,
        temperature,
        LAG(recordDate) OVER(ORDER BY recordDate) AS prev_date,
        LAG(temperature) OVER(ORDER BY recordDate) AS prev_temperature
    FROM Weather
) w
WHERE recordDate = prev_date + INTERVAL 1 DAY AND temperature > prev_temperature;