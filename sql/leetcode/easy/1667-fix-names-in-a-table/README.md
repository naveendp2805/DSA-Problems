# Fix Names in a Table

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Table: `Users`

```
+----------------+---------+
| Column Name    | Type    |
+----------------+---------+
| user_id        | int     |
| name           | varchar |
+----------------+---------+
user_id is the primary key (column with unique values) for this table.
This table contains the ID and the name of the user. The name consists of only lowercase and uppercase characters.

```

 

Write a solution to fix the names so that only the first character is uppercase and the rest are lowercase.

Return the result table ordered by `user_id`.

The result format is in the following example.

 

 **Example 1:** 

```
Input: 
Users table:
+---------+-------+
| user_id | name  |
+---------+-------+
| 1       | aLice |
| 2       | bOB   |
+---------+-------+
Output: 
+---------+-------+
| user_id | name  |
+---------+-------+
| 1       | Alice |
| 2       | Bob   |
+---------+-------+

```

## Solution

**Language:** SQL  
**Runtime:** 655 ms (beats 84.17%)  
**Memory:** 0B (beats 100.00%)  
**Submitted:** 2026-09-15T10:14:23.528Z  

```sql
# Write your MySQL query statement below
SELECT
    user_id,
    CONCAT(
        UPPER(SUBSTR(name, 1, 1)),
        LOWER(SUBSTR(name, 2))
    ) AS name
FROM Users
ORDER BY user_id;
```

---

[View on LeetCode](https://leetcode.com/problems/fix-names-in-a-table/)