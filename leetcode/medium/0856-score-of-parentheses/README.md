# Score of Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a balanced parentheses string `s`, return  *the  **score**  of the string*.

The  **score**  of a balanced parentheses string is based on the following rule:

- "()" has score 1.
- AB has score A + B, where A and B are balanced parentheses strings.
- (A) has score 2 * A, where A is a balanced parentheses string.

 

 **Example 1:** 

```
Input: s = "()"
Output: 1

```

 **Example 2:** 

```
Input: s = "(())"
Output: 2

```

 **Example 3:** 

```
Input: s = "()()"
Output: 2

```

 

 **Constraints:** 

- 2 <= s.length <= 50
- s consists of only '(' and ')'.
- s is a balanced parentheses string.

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 43 MB (beats 12.37%)  
**Submitted:** 2026-10-05T05:28:58.235Z  

```java
class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        int res = 0, depth = 0;

        for(int i=0; i<n; i++)
        {
            if(s.charAt(i) == '(')
                depth++;
            else
            {
                depth--;
                if(s.charAt(i-1) == '(')
                    res += 1 << depth;
            }
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/score-of-parentheses/)