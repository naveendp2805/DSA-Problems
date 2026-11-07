# Q1. Remove Duplicate Letters

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s`, remove duplicate letters so that every letter appears once and only once. The relative order of the letters that were not removed must be preserved. You must make sure your result is  **the smallest in lexicographical order**  among all possible results.

 

 **Example 1:** 

```
Input: s = "bcabc"
Output: "abc"

```

 **Example 2:** 

```
Input: s = "cbacdcbc"
Output: "acdb"

```

 

 **Constraints:** 

- 1 <= s.length <= 104
- s consists of lowercase English letters.

 

 **Note:**  This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 80.11%)  
**Memory:** 42.6 MB (beats 98.81%)  
**Submitted:** 2026-11-07T06:23:14.014Z  

```java

class Solution {
    public String removeDuplicateLetters(String s) {

        int[] freq = new int[26];
        boolean[] seen = new boolean[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {

            freq[ch - 'a']--;

            if (seen[ch - 'a']) {
                continue;
            }

            while (stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > ch &&
                   freq[stack.charAt(stack.length() - 1) - 'a'] > 0) {

                char removed = stack.charAt(stack.length() - 1);

                stack.deleteCharAt(stack.length() - 1);

                seen[removed - 'a'] = false;
            }

            stack.append(ch);
            seen[ch - 'a'] = true;
        }

        return stack.toString();
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/)