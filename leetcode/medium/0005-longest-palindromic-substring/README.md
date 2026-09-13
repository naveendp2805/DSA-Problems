# Longest Palindromic Substring

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s`, return  *the longest*   *palindromic*   *substring*  in `s`.

 

 **Example 1:** 

```
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

```

 **Example 2:** 

```
Input: s = "cbbd"
Output: "bb"

```

 

 **Constraints:** 

- 1 <= s.length <= 1000
- s consist of only digits and English letters.

## Solution

**Language:** Java  
**Runtime:** 574 ms (beats 13.90%)  
**Memory:** 47 MB (beats 22.12%)  
**Submitted:** 2026-09-13T07:53:17.287Z  

```java
class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 1, n = s.length();
        String maxStr = s.substring(0, 1);

        for(int i=0; i<n; i++)
        {
            for(int j=i+maxLen; j<=n; j++)
            {
                String sub = s.substring(i, j);

                if(j - i > maxLen && isPallindrome(sub))
                {
                    maxLen = j - i;
                    maxStr = sub;
                }
            }
        }

        return maxStr;
    }

    private static boolean isPallindrome(String s)
    {
        int i=0, j=s.length() - 1;

        while(i < j)
        {
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }

        return true;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-palindromic-substring/)