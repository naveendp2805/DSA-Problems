# Word Search

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an `m x n` grid of characters `board` and a string `word`, return `true`  *if*  `word`  *exists in the grid*.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

 **Example 1:** 

```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

```

 **Example 2:** 

```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

```

 **Example 3:** 

```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

```

 

 **Constraints:** 

- m == board.length
- n = board[i].length
- 1 <= m, n <= 6
- 1 <= word.length <= 15
- board and word consists of only lowercase and uppercase English letters.

 

 **Follow up:**  Could you use search pruning to make your solution faster with a larger `board`?

## Solution

**Language:** Java  
**Runtime:** 141 ms (beats 44.95%)  
**Memory:** 43.1 MB (beats 43.83%)  
**Submitted:** 2026-09-23T15:27:32.822Z  

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(check(board, visited, word, i, j, 0))
                    return true;
            }
        }

        return false;
    }

    private static boolean check(char[][] board, boolean[][] visited, String word, int i, int j, int k)
    {
        if(k == word.length())
            return true;

        if(i < 0 || i == board.length || j < 0 || j == board[0].length || visited[i][j] || board[i][j] != word.charAt(k))
            return false;

        visited[i][j] = true;

        if(check(board, visited, word, i-1, j, k+1) || check(board, visited, word, i+1, j, k+1) ||
            check(board, visited, word, i, j-1, k+1) || check(board, visited, word, i, j+1, k+1))
            return true;

        visited[i][j] = false;

        return false;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/word-search/)