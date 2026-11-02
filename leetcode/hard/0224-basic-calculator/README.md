# Basic Calculator

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a string `s` representing a valid expression, implement a basic calculator to evaluate it, and return  *the result of the evaluation*.

 **Note:**  You are  **not**  allowed to use any built-in function which evaluates strings as mathematical expressions, such as `eval()`.

 

 **Example 1:** 

```
Input: s = "1 + 1"
Output: 2

```

 **Example 2:** 

```
Input: s = " 2-1 + 2 "
Output: 3

```

 **Example 3:** 

```
Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23

```

 

 **Constraints:** 

- 1 <= s.length <= 3 * 105
- s consists of digits, '+', '-', '(', ')', and ' '.
- s represents a valid expression.
- '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
- '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
- There will be no two consecutive operators in the input.
- Every number and running calculation will fit in a signed 32-bit integer.

## Solution

**Language:** Java  
**Runtime:** 9 ms (beats 92.49%)  
**Memory:** 45.5 MB (beats 99.49%)  
**Submitted:** 2026-11-02T15:46:07.779Z  

```java
class Solution {
    public int calculate(String s) {
        int res = 0;
        int curr = 0, sign = 1;

        Stack<Integer> stack = new Stack<>();

        for(char ch : s.toCharArray())
        {
            if(Character.isDigit(ch)) {
                curr = curr * 10 + ch - '0';
            } else if(ch == '+') {
                res += curr * sign;
                sign = 1;
                curr = 0;
            } else if(ch == '-') {
                res += curr * sign;
                sign = -1;
                curr = 0;
            } else if(ch == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                curr = 0;
                sign = 1;
            } else if(ch == ')') {
                res += curr * sign;
                curr = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }

        res += curr * sign;

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/basic-calculator/)