# Write your MySQL query statement below
WITH ranked_reviews AS (
    SELECT
        pr.employee_id,
        e.name,
        pr.rating,
        ROW_NUMBER() OVER(
            PARTITION BY pr.employee_id
            ORDER BY pr.review_date DESC
        ) AS rnk
    FROM performance_reviews pr
    JOIN employees e
        ON pr.employee_id = e.employee_id
),
last_3 AS(
    SELECT 
        employee_id,
        name,
        rating,
        rnk
    FROM ranked_reviews
    WHERE rnk <= 3
),
grouped AS (
    SELECT
        employee_id,
        name,
        MAX(CASE WHEN rnk = 1 THEN rating END) AS latest_rating,
        MAX(CASE WHEN rnk = 2 THEN rating END) AS middle_rating,
        MAX(CASE WHEN rnk = 3 THEN rating END) AS earliest_rating
    FROM last_3
    GROUP BY employee_id, name
)
SELECT
    employee_id,
    name,
    latest_rating - earliest_rating AS improvement_score
FROM grouped
WHERE earliest_rating < middle_rating
    AND middle_rating < latest_rating
ORDER BY improvement_score DESC, name ASC;
    