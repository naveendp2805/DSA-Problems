# minimum-time1238

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

_Description not available._

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T16:12:50.133Z  

```java
class Solution {
    public int minCost(int n, int i, int d, int c) {
        // code here
        int dp[] = new int[n+1];
        dp[1] = i;
        for(int k=2;k<=n;k++){

            int min = dp[k-1] + i;
            if(k%2==0){

                min = Math.min(dp[k/2]+c, min);
            }else{
               min = Math.min(min, Math.min(dp[k/2]+c+i, dp[k/2 +1]+c+d)); 
            }
            dp[k] = min;
        }
        return dp[n];
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/minimum-time1238/1)