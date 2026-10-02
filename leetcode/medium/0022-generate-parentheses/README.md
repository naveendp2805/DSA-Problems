# Generate Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given `n` pairs of parentheses, write a function to  *generate all combinations of well-formed parentheses*.

 

 **Example 1:** 

```
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

```

 **Example 2:** 

```
Input: n = 1
Output: ["()"]

```

 

 **Constraints:** 

- 1 <= n <= 8

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 68.84%)  
**Memory:** 44.6 MB (beats 54.52%)  
**Submitted:** 2026-10-02T05:44:41.448Z  

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        generateParenthesis(n, n, res, "");

        return res;
    }

    private void generateParenthesis(int open, int close, List<String> res, String comb)
    {
        if(open == 0 && close == 0) {
            res.add(comb);
            return;
        }

        if(open > 0) {
            generateParenthesis(open - 1, close, res, comb + "(");
        }

        if(close > open) {
            generateParenthesis(open, close - 1, res, comb + ")");
        }
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/generate-parentheses/)