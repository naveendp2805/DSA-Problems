# Search in Rotated Array 2

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a sorted and rotated array  **arr[]**  and a target  **key**. Check whether the key is present in the array or not.

 **Note:**  The array may contains duplicate elements.

 **Examples:** 

```
Input: arr[] = [3, 3, 3, 1, 2, 3], key = 3
Output: true
Explanation: 3 is present in the array.
```

```
Input: arr[] = [4, 5, 8, 1, 1, 1, 2], key = 6
Output: false
Explanation: 6 is not present in the array.
```

 **Constraints** :
1 ≤ arr.size() ≤ 106
0 ≤ arr[i], key ≤ 108

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-03T07:29:58.119Z  

```java
class Solution {
    public boolean search(int[] arr, int target) {
        // code here
        int l=0, h=arr.length-1;
        while(l <= h)
        {
            int mid = l + (h-l)/2;
            if(target == arr[mid])
                return true;
            if(arr[l] == arr[mid] && arr[h] == arr[mid])
            {
                l++;
                h--;
            }
            else if(arr[l] <= arr[mid])
            {
                if(target >= arr[l] && target < arr[mid])
                    h = mid-1;
                else l = mid+1;
            }
            else 
            {
                if(target <= arr[h] && target > arr[mid])
                    l = mid + 1;
                else h = mid - 1;
            }
        }
        
        return false;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/search-in-rotated-array-2/1)