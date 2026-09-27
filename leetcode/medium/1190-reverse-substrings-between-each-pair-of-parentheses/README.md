# Reverse Substrings Between Each Pair of Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a string `s` that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should  **not**  contain any brackets.

 

 **Example 1:** 

```
Input: s = "(abcd)"
Output: "dcba"

```

 **Example 2:** 

```
Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.

```

 **Example 3:** 

```
Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.

```

 

 **Constraints:** 

- 1 <= s.length <= 2000
- s only contains lower case English characters and parentheses.
- It is guaranteed that all parentheses are balanced.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 91.56%)  
**Memory:** 42.8 MB (beats 94.73%)  
**Submitted:** 2026-09-27T16:07:13.069Z  

```java
class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();

        StringBuilder res = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int[] link = new int[n];

        for(int i=0; i<n; i++)
        {
            char ch = s.charAt(i);

            if(ch == '(')
                stack.push(i);
            else if(ch == ')')
            {
                link[i] = stack.pop();
                link[link[i]] = i;
            }
        }

        int i = 0, dir = 1;

        while(i < n)
        {
            char ch = s.charAt(i);

            if(Character.isLetter(ch))
                res.append(ch);
            else
            {
                dir = -dir;
                i = link[i];
            }

            i += dir;
        }

        return res.toString();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/)