# Maximum Number of Non-overlapping Palindrome Substrings

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a string `s` and a  **positive**  integer `k`.

Select a set of  **non-overlapping**  substrings from the string `s` that satisfy the following conditions:

- The length of each substring is at least k.
- Each substring is a palindrome.

Return  *the  **maximum**  number of substrings in an optimal selection*.

A  **substring**  is a contiguous sequence of characters within a string.

 

 **Example 1:** 

```
Input: s = "abaccdbbd", k = 3
Output: 2
Explanation: We can select the substrings underlined in s = "abaccdbbd". Both "aba" and "dbbd" are palindromes and have a length of at least k = 3.
It can be shown that we cannot find a selection with more than two valid substrings.

```

 **Example 2:** 

```
Input: s = "adbcda", k = 2
Output: 0
Explanation: There is no palindrome substring of length at least 2 in the string.

```

 

 **Constraints:** 

- 1 <= k <= s.length <= 2000
- s consists of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 100.00%)  
**Memory:** 41.6 MB (beats 100.00%)  
**Submitted:** 2026-09-15T06:35:52.737Z  

```java
class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();

        if(k == 1) return n;

        int res = 0;
        
        for(int i=0; i <= n-k; i++)
        {
            if(isPallindrome(s, i, i+k-1)) {
                res++;
                i = i + k - 1;
            } else if(i < (n - k) && isPallindrome(s, i, i+k)) {
                res++;
                i = i + k;
            }
        }

        return res;
    }

    private static boolean isPallindrome(String s, int i, int j)
    {
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

[View on LeetCode](https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/)