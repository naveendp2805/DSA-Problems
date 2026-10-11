# Sort Two Parts  Sorted

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an integer array  **arr[]**  where the two parts around a break point are individually sorted, merge them into a single sorted array.  The break point can be anywhere in the array, including at the beginning or end.

 **Examples:** 

```
Input: arr[] = [2, 3, 8, -1, 7, 10]
Output: [-1, 2, 3, 7, 8, 10] 
Explanation: [2, 3, 8] and [-1, 7, 10] are sorted in the original array. The overall sorted version is [-1 2 3 7 8 10].
```

```
Input: arr[] = [-4, 6, 9, -1, 3]
Output: [-4, -1, 3, 6, 9]
Explanation: [-4, 6, 9] and [-1, 3] are sorted in the original array. The overall sorted version is [-4 -1 3 6 9].
```

```
Input: arr[] = [10, 20, 30]
Output: [10, 20, 30]
Explanation: One part is empty and the other part is whole array which is already sorted.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-11T14:26:06.797Z  

```java
class Solution {
    public void mergeTwoParts(int[] arr) {
        // code here
        int bp = -1, n = arr.length;
        
        for(int i=1; i<n; i++)
        {
            if(arr[i] < arr[i-1])
            {
                bp = i;
                break;
            }
        }
        
        if(bp == -1) return ;
        
        int[] res = new int[n];
        
        merge(arr, res, bp, n);
        
        for(int i=0; i<n; i++)
            arr[i] = res[i];
        
    }
    
    private void merge(int[] arr, int[] res, int bp, int n)
    {
        int i=0, j = bp, x = 0;
        
        while(i < bp && j < n)
        {
            if(arr[i] < arr[j])
                res[x++] = arr[i++];
            else
                res[x++] = arr[j++];
        }
        
        while(i < bp)
            res[x++] = arr[i++];
            
        while(j < n)
            res[x++] = arr[j++];
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/sort-the-half-sorted2157/1)