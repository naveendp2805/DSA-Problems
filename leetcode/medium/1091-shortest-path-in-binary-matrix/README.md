# Shortest Path in Binary Matrix

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an `n x n` binary matrix `grid`, return  *the length of the shortest  **clear path**  in the matrix*. If there is no clear path, return `-1`.

A  **clear path**  in a binary matrix is a path from the  **top-left**  cell (i.e., `(0, 0)`) to the  **bottom-right**  cell (i.e., `(n - 1, n - 1)`) such that:

- All the visited cells of the path are 0.
- All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).

The  **length of a clear path**  is the number of visited cells of this path.

 

 **Example 1:** 

```
Input: grid = [[0,1],[1,0]]
Output: 2

```

 **Example 2:** 

```
Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4

```

 **Example 3:** 

```
Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1

```

 

 **Constraints:** 

- n == grid.length
- n == grid[i].length
- 1 <= n <= 100
- grid[i][j] is 0 or 1

## Solution

**Language:** Java  
**Runtime:** 13 ms (beats 81.35%)  
**Memory:** 47.7 MB (beats 59.83%)  
**Submitted:** 2026-09-18T15:23:45.357Z  

```java
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)
            return -1;

        int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},         {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        grid[0][0] = 1;

        int length = 1;

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i=0; i<size; i++)
            {
                int[] ele = q.poll();
                int r = ele[0], c = ele[1];

                if(r == n-1 && c == n-1)
                    return length;

                for(int[] dir : dirs)
                {
                    int rn = r + dir[0], cn = c + dir[1];

                    if(rn >= 0 && rn < n && cn >= 0 && cn < n && grid[rn][cn] == 0)
                    {
                        grid[rn][cn] = 1;
                        q.offer(new int[]{rn, cn});
                    }
                }
            }

            length++;
        }

        return -1;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/shortest-path-in-binary-matrix/)