# Longest Substring Without Repeating Characters

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s`, find the length of the  **longest**   **substring**  without duplicate characters.

 

 **Example 1:** 

```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

```

 **Example 2:** 

```
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

```

 **Example 3:** 

```
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

```

 

 **Constraints:** 

- 0 <= s.length <= 105
- s consists of English letters, digits, symbols and spaces.

## Solution

**Language:** Java  
**Runtime:** 61 ms (beats 62.54%)  
**Memory:** 48.1 MB (beats 26.13%)  
**Submitted:** 2026-10-02T07:02:08.715Z  

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), i = 0;
        int res = 0;

        Set<Character> set = new HashSet<>();

        for(int j=0; j<n; j++)
        {
            char ch = s.charAt(j);

            while(set.contains(ch))
            {
                set.remove(s.charAt(i));
                i++;
            }

            set.add(ch);

            res = Math.max(res, j-i+1);
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-substring-without-repeating-characters/)