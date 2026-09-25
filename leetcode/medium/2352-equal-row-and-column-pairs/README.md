# Equal Row and Column Pairs

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a  **0-indexed**  `n x n` integer matrix `grid`,  *return the number of pairs* `(ri, cj)` *such that row* `ri` *and column* `cj` *are equal*.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

 

 **Example 1:** 

```
Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]

```

 **Example 2:** 

```
Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]

```

 

 **Constraints:** 

- n == grid.length == grid[i].length
- 1 <= n <= 200
- 1 <= grid[i][j] <= 105

## Solution

**Language:** Java  
**Runtime:** 17 ms (beats 94.21%)  
**Memory:** 54.5 MB (beats 25.15%)  
**Submitted:** 2026-09-25T14:18:47.726Z  

```java
class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length, res = 0;

        Map<List<Integer>, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++)
        {
            List<Integer> row = new ArrayList<>();

            for(int j=0; j<n; j++)
                row.add(grid[i][j]);

            map.put(row, map.getOrDefault(row, 0) + 1);
        }

        for(int i=0; i<n; i++)
        {
            List<Integer> column = new ArrayList<>();

            for(int j=0; j<n; j++)
                column.add(grid[j][i]);

            res += map.getOrDefault(column, 0);
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/equal-row-and-column-pairs/)