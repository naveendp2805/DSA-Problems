# Q2. Sort an Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of integers `nums`, sort the array in ascending order and return it.

You must solve the problem  **without using any built-in**  functions in `O(nlog(n))` time complexity and with the smallest space complexity possible.

 

Original
Java
 **Example 1:** 

```
Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).

```

 **Example 2:** 

```
Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessarily unique.

```

 

 **Constraints:** 

- 1 <= nums.length <= 5 * 104
- -5  *104 <= nums[i] <= 5*  104

## Solution

**Language:** Java  
**Runtime:** 24 ms (beats 90.06%)  
**Memory:** 80 MB (beats 89.86%)  
**Submitted:** 2026-11-20T06:48:42.392Z  

```java
class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        int[] temp = new int[n];

        mergeSort(nums, temp, 0, n-1);

        return nums;
    }

    private void mergeSort(int[] nums, int[] temp, int left, int right)
    {
        if(left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(nums, temp, left, mid);
        mergeSort(nums, temp, mid+1, right);

        merge(nums, temp, left, mid, right);
    }

    private void merge(int[] nums, int[] temp, int left, int mid, int right)
    {
        int i = left;
        int j = mid + 1;
        int x = left;

        while(i <= mid && j <= right) 
        {
            if(nums[i] <= nums[j]) {
                temp[x++] = nums[i++];
            } else {
                temp[x++] = nums[j++];
            }
        }

        while(i <= mid) {
            temp[x++] = nums[i++];
        }
        
        while(j <= right) {
            temp[x++] = nums[j++];
        }

        for(i=left; i<=right; i++) {
            nums[i] = temp[i];
        }
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/sort-an-array/)