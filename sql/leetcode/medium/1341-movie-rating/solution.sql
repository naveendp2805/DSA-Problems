# Write your MySQL query statement below
(SELECT
    u.name AS results
FROM Users u
JOIN MovieRating mr
    ON u.user_id = mr.user_id
GROUP BY mr.user_id
ORDER BY COUNT(*) DESC, u.name ASC
LIMIT 1)

UNION ALL

(SELECT
    m.title AS results
FROM Movies m
JOIN MovieRating mr
    USING(movie_id)
WHERE LEFT(mr.created_at, 7) = '2020-02'
GROUP BY mr.movie_id
ORDER BY AVG(mr.rating) DESC, m.title ASC
LIMIT 1);