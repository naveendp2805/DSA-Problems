# Edit Distance

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two strings `word1` and `word2`, return  *the minimum number of operations required to convert `word1` to `word2`*.

You have the following three operations permitted on a word:

- Insert a character
- Delete a character
- Replace a character

 

 **Example 1:** 

```
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

```

 **Example 2:** 

```
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

```

 

 **Constraints:** 

- 0 <= word1.length, word2.length <= 500
- word1 and word2 consist of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 8.45%)  
**Memory:** 46.4 MB (beats 93.95%)  
**Submitted:** 2026-10-15T16:32:23.927Z  

```java
class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();

        int[][] dp = new int[n1+1][n2+1];

        for(int j=0; j<=n2; j++)
            dp[0][j] = j;

        for(int i=1; i<=n1; i++)
            dp[i][0] = i;

        for(int i=1; i<=n1; i++)
        {
            for(int j=1; j<=n2; j++)
            {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
            }
        }

        return dp[n1][n2];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/edit-distance/)