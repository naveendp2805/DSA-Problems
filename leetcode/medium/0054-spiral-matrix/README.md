# Spiral Matrix

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an `m x n` `matrix`, return  *all elements of the*  `matrix`  *in spiral order*.

 

 **Example 1:** 

```
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

```

 **Example 2:** 

```
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

```

 

 **Constraints:** 

- m == matrix.length
- n == matrix[i].length
- 1 <= m, n <= 10
- -100 <= matrix[i][j] <= 100

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 43.2 MB (beats 9.57%)  
**Submitted:** 2026-09-16T10:45:58.343Z  

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        List<Integer> res = new ArrayList<>();

        int x = 0, y = 0;
        int dx = 1, dy = 0;

        for(int i=0; i<m*n; i++)
        {
            res.add(matrix[y][x]);
            matrix[y][x] = -101;

            int new_x = x + dx; 
            int new_y = y + dy;

            if(!(new_x >= 0 && new_x < n && new_y >= 0 && new_y < m) || matrix[new_y][new_x] == -101)
            {
                int temp = dx;
                dx = -dy;
                dy = temp;       
            }

            x += dx;
            y += dy;
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/spiral-matrix/)