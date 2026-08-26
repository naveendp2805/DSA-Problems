# Minimum Moves to Sort Permutation

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**  containing integers from  **1**  to  **n**  exactly once, sort the array in ascending order.

In one operation, you can pick any element and move it either to the beginning or to the end of the array.

Return the minimum number of operations required to sort the array.

 **Examples:** 

```
Input: arr[] = [2, 1, 3]
Output: 1
Explanation: Move 1 to the beginning.
```

```
Input: arr[] = [4, 3, 1, 2]
Output: 2
Explanation: Move 3 to the end to get [4, 1, 2, 3]. Then move 4 to the end to get [1, 2, 3, 4].
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-26T16:15:09.656Z  

```java
class Solution {
    public int minMoves(int[] arr) {
        // code here
        int n = arr.length, res = 0;
        int[] dp = new int[n + 1];
        
        for(int i=0; i<n; i++)
        {
            int num = arr[i];
            
            dp[num] = dp[num - 1] + 1;
            res = Math.max(res, dp[num]);
        }
        
        return n - res;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/morning-assembly3038/1)