# Q1. Minimum Absolute Difference

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array of  **distinct**  integers `arr`, find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair `[a, b]` follows

- a, b are from arr
- a < b
- b - a equals to the minimum absolute difference of any two elements in arr

 

Original
Java
 **Example 1:** 

```
Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
```

 **Example 2:** 

```
Input: arr = [1,3,6,10,15]
Output: [[1,3]]

```

 **Example 3:** 

```
Input: arr = [3,8,-10,23,19,-4,-14,27]
Output: [[-14,-10],[19,23],[23,27]]

```

 

 **Constraints:** 

- 2 <= arr.length <= 105
- -106 <= arr[i] <= 106

## Solution

**Language:** Java  
**Runtime:** 22 ms (beats 40.50%)  
**Memory:** 63.3 MB (beats 77.17%)  
**Submitted:** 2026-11-20T06:12:38.574Z  

```java
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for(int i=1; i<n; i++) {
            min = Math.min(min, arr[i] - arr[i-1]);
        }

        for(int i=1; i<n; i++) {
            if(arr[i] - arr[i-1] == min) {
                res.add(new ArrayList<>(Arrays.asList(arr[i-1], arr[i])));
            }
        }
        
        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-absolute-difference/)