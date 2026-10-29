# Check if Every Row and Column Contains All Numbers

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

An `n x n` matrix is  **valid**  if every row and every column contains  **all**  the integers from `1` to `n` (**inclusive**).

Given an `n x n` integer matrix `matrix`, return `true`  *if the matrix is  **valid**.*  Otherwise, return `false`.

 

 **Example 1:** 

```
Input: matrix = [[1,2,3],[3,1,2],[2,3,1]]
Output: true
Explanation: In this case, n = 3, and every row and column contains the numbers 1, 2, and 3.
Hence, we return true.

```

 **Example 2:** 

```
Input: matrix = [[1,1,1],[1,2,3],[1,2,3]]
Output: false
Explanation: In this case, n = 3, but the first row and the first column do not contain the numbers 2 or 3.
Hence, we return false.

```

 

 **Constraints:** 

- n == matrix.length == matrix[i].length
- 1 <= n <= 100
- 1 <= matrix[i][j] <= n

## Solution

**Language:** Java  
**Runtime:** 5 ms (beats 78.40%)  
**Memory:** 48.1 MB (beats 29.61%)  
**Submitted:** 2026-10-29T06:04:44.696Z  

```java
class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for(int i=0; i<n; i++)
        {
            boolean[] row = new boolean[n+1];
            boolean[] col = new boolean[n+1];

            for(int j=0; j<n; j++)
            {
                int r = matrix[i][j];
                int c = matrix[j][i];

                if(row[r] || col[c])
                    return false;

                row[r] = true;
                col[c] = true;
            }
        }

        return true;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/)