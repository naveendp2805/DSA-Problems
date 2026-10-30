# Game of Life

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

According to Wikipedia's article: "The  **Game of Life**, also known simply as  **Life**, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an `m x n` grid of cells, where each cell has an initial state:  **live**  (represented by a `1`) or  **dead**  (represented by a `0`). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

- Any live cell with fewer than two live neighbors dies as if caused by under-population.
- Any live cell with two or three live neighbors lives on to the next generation.
- Any live cell with more than three live neighbors dies, as if by over-population.
- Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the `m x n` grid `board`. In this process, births and deaths occur  **simultaneously**.

Given the current state of the `board`,  **update**  the `board` to reflect its next state.

 **Note**  that you do not need to return anything.

 

 **Example 1:** 

```
Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

```

 **Example 2:** 

```
Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]

```

 

 **Constraints:** 

- m == board.length
- n == board[i].length
- 1 <= m, n <= 25
- board[i][j] is 0 or 1.

 

 **Follow up:** 

- Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
- In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.8 MB (beats 82.78%)  
**Submitted:** 2026-10-30T07:51:48.885Z  

```java
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        int[][] next = new int[m][n];

        int[][] dirs = {{-1, -1}, {-1, 0},  {-1, 1},
                        {0, -1},            {0, 1},
                        {1, -1},  {1, 0},   {1, 1}};

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                int ones = 0;
                for(int[] dir : dirs)
                {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if(x < 0 || x >= m || y < 0 || y >= n)
                        continue;

                    if(board[x][y] == 1)
                        ones++;
                    
                }

                if(board[i][j] == 0) {
                    next[i][j] = ones == 3 ? 1 : 0;
                }
                else {
                    next[i][j] = (ones < 2 || ones > 3) ? 0 : 1;
                }
            }
        }

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                board[i][j] = next[i][j];
            }
        }
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/game-of-life/)