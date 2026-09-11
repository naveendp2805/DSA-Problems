# Pairs with Given GCD and LCM

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two integers  **x**  and  **y**  representing the GCD and LCM of two unknown positive integers  **a**  and  **b**, count the number of valid pairs  **(a, b)**  satisfying these conditions. Note that  **(a, b)** and  **(b, a)**  are counted as distinct pairs when  **a ≠ b**.

 **Examples:** 

```
Input: x = 2, y = 12
Output: 4
Explanation: The valid pairs are (2, 12), (4, 6), (6, 4), and (12, 2), since each pair has GCD = 2 and LCM = 12.
```

```
Input: x = 6, y = 4
Output: 0
Explanation: LCM must always be a multiple of GCD. Since y is not divisible by x, no valid pair exists.
```

 **Constraints:** 
1 ≤ x, y ≤ 104

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-11T15:20:24.511Z  

```java
class Solution {
    public int pairCount(int x, int y) {
        // code here
        if(y % x != 0) return 0;
        
        int k = y / x;
        int res = 0;
        
        for(int i=2; i*i<=k; i++)
        {
            if(k % i == 0) 
                res++;
            
            while(k % i == 0) 
                k /= i;
        }
        
        if(k > 1) res++;
        
        return 1 << res;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/possible-pairs1550/1)