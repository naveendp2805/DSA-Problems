# Integer to English Words

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Convert a non-negative integer `num` to its English words representation.

 

 **Example 1:** 

```
Input: num = 123
Output: "One Hundred Twenty Three"

```

 **Example 2:** 

```
Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"

```

 **Example 3:** 

```
Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

```

 

 **Constraints:** 

- 0 <= num <= 231 - 1

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 78.21%)  
**Memory:** 44.3 MB (beats 59.42%)  
**Submitted:** 2026-09-13T15:53:45.397Z  

```java
class Solution {
    public String numberToWords(int num) {
        if(num == 0) return "Zero";

        String res = helper(num%1000);
        num /= 1000;

        if(num>0 && num%1000 > 0)
            res = helper(num%1000) + "Thousand " + res;
        num /= 1000;

        if(num>0 && num%1000 > 0)
            res = helper(num%1000) + "Million " + res;
        num /= 1000;

        if(num > 0)
            res = helper(num) + "Billion " + res;
            
        return res.trim();        
    }

    private static String helper(int n)
    {
        String[] digitString = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

        String[] teenString = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
                                 "Seventeen", "Eighteen", "Nineteen"};

        String[] tenString = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
                             "Ninety"};

        String res = "";

        if(n > 99)
            res += digitString[n/100] + " Hundred ";
        n %= 100;

        if(n > 9 && n < 20)
            res += teenString[n%10] + " ";
        else
        {
            if(n > 19)
                res += tenString[n/10] + " ";
            n %= 10;

            if(n > 0)
                res += digitString[n] + " ";
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/integer-to-english-words/)