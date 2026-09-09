# Max Digit Sum Number in 1 to n

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a number  **n**, find a number in the range from 1 to  **n** such that its digit sum is maximum. If there are multiple such numbers, return the largest of them.

 **Examples:** 

```
Input: n = 48
Output: 48
Explanation: There are two numbers with maximum digit sum = 12. The numbers are 48 and 39. Since 48 > 39, so 48 is the answer.
```

```
Input: n = 90
Output: 89
Explanation: 89 gives us the largest digit sum in the range from 1 to n. Hence the answer is 89. 
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-09T10:52:59.409Z  

```java
class Solution {
    public int findMax(int n) {
        // code here
        int res = n, maxSum = digitSum(n);
        
        for(int p=10; p<=n; p*=10)
        {
            int num = (n / p - 1) * p + (p-1);
            
            int sum = digitSum(num);
            
            if(sum > maxSum || (sum == maxSum && num > n))
            {
                res = num;
                maxSum = sum;
            }
        }
        
        return res;
    }
    
    private static int digitSum(int n)
    {
        int sum = 0;
        
        while(n > 0)
        {
            sum += n % 10;
            n /= 10;
        }
        
        return sum;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/biggest-integer-having-maximum-digit-sum1704/1)