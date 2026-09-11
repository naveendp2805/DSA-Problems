# Write your MySQL query statement below
SELECT 
    s.student_id, 
    s.student_name, 
    su.subject_name, 
    COUNT(e.student_id) AS attended_exams
FROM Students s
CROSS JOIN Subjects su
Left JOIN Examinations e
    ON s.student_id = e.student_id AND
        su.subject_name = e.subject_name
Group By s.student_id, s.student_name, su.subject_name
ORDER BY S.student_id, S.student_name, su.subject_name;