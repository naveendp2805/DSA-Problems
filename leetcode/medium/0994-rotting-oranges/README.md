# Rotting Oranges

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an `m x n` `grid` where each cell can have one of three values:

- 0 representing an empty cell,
- 1 representing a fresh orange, or
- 2 representing a rotten orange.

Every minute, any fresh orange that is  **4-directionally adjacent**  to a rotten orange becomes rotten.

Return  *the minimum number of minutes that must elapse until no cell has a fresh orange*. If  *this is impossible, return*  `-1`.

 

 **Example 1:** 

```
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

```

 **Example 2:** 

```
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

```

 **Example 3:** 

```
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

```

 

 **Constraints:** 

- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 10
- grid[i][j] is 0, 1, or 2.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 86.80%)  
**Memory:** 44.4 MB (beats 24.22%)  
**Submitted:** 2026-10-06T13:00:42.864Z  

```java
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int freshOranges = 0;

        Queue<int[]> q = new LinkedList<>();

        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 2)
                    q.offer(new int[]{i, j});
                else if(grid[i][j] == 1)
                    freshOranges++;
            }
        }

        if(freshOranges == 0)
            return 0;

        if(q.isEmpty())
            return -1;

        int x, y;
        int mins = -1;

        while(!q.isEmpty())
        {
            int size = q.size();

            while(size-- > 0)
            {
                int[] curr = q.poll();

                for(int[] dir : dirs)
                {
                    x = curr[0] + dir[0];
                    y = curr[1] + dir[1];

                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1)
                    {
                        grid[x][y] = 2;
                        freshOranges--;
                        q.offer(new int[]{x, y});
                    }
                }
            }

            mins++;
        }

        return freshOranges == 0 ? mins : -1;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/rotting-oranges/)