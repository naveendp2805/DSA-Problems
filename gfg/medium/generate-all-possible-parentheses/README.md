# Generate Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a number  **n**, return all the combinations of balanced parentheses of length n.
 **Note:**  A sequence of parentheses is  **balanced**  if every opening bracket has a corresponding closing bracket in the  **correct order**.
For example, "(())", "()()", and "(()())" are balanced, whereas ")()(", "))((", and "()))" are not.

 **Examples:** 

```
Input: n = 6
Output: ["((()))", "(()())", "(())()", "()(())", "()()()"]
Explanation: These are the only possible valid balanced parentheses.
```

```
Input: n = 4
Output: ["(())", "()()"]
Explanation: These are the only possible valid balanced parentheses.
```

 **Constraints:** 
1 ≤ n ≤ 16
n % 2 == 0

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-02T06:19:53.858Z  

```java
class Solution {
    public ArrayList<String> generateParentheses(int n) {
        // code here
        ArrayList<String> res = new ArrayList<>();

        generateParenthesis(n/2, n/2, res, "");

        return res;
    }

    private void generateParenthesis(int open, int close, ArrayList<String> res, String comb)
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

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/generate-all-possible-parentheses/1)