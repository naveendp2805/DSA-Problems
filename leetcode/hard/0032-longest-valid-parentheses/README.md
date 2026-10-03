# Longest Valid Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a string containing just the characters `'('` and `')'`, return  *the length of the longest valid (well-formed) parentheses **substring*.

 

 **Example 1:** 

```
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

```

 **Example 2:** 

```
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

```

 **Example 3:** 

```
Input: s = ""
Output: 0

```

 

 **Constraints:** 

- 0 <= s.length <= 3 * 104
- s[i] is '(', or ')'.

## Solution

**Language:** Java  
**Runtime:** 5 ms (beats 75.27%)  
**Memory:** 46.6 MB (beats 25.60%)  
**Submitted:** 2026-10-03T05:37:00.852Z  

```java
class Solution {
    public int longestValidParentheses(String s) {
        int res = 0, n = s.length();

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int i=0; i<n; i++)
        {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-valid-parentheses/)