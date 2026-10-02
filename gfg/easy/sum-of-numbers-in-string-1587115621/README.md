# Sum Numbers in a String

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a string  **s** containing alphanumeric characters. You have to calculate the sum of all the numbers present in the string.

 **Examples:** 

```
Input: s = "1abc23"
Output: 24
Explanation: 1 and 23 are numbers in the string which is added to get the sum as 24.

```

```
Input: s = "geeks4geeks"
Output: 4
Explanation: 4 is the only number, so the sum is 4.
```

 **Constraints:** 
1 ≤ |s|≤ 105
The sum of Numbers ≤ 105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-02T07:12:55.447Z  

```java
class Solution {
    public static int findSum(String s) {
        // code here
        int res = 0, sum = 0;
        
        for(char ch : s.toCharArray())
        {
            if(Character.isDigit(ch)) {
                sum = sum * 10 + (ch - '0');
            } else {
                res += sum;
                sum = 0;
            }
        }
        
        if(sum > 0)
            res += sum;
            
        return res;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/sum-of-numbers-in-string-1587115621/1)