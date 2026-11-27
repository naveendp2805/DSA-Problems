# Q3. Reverse Pairs

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an integer array `nums`, return  *the number of  **reverse pairs**  in the array*.

A  **reverse pair**  is a pair `(i, j)` where:

- 0 <= i < j < nums.length and
- nums[i] > 2 * nums[j].

 

Original
Java
 **Example 1:** 

```
Input: nums = [1,3,2,3,1]
Output: 2
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1

```

 **Example 2:** 

```
Input: nums = [2,4,3,5,1]
Output: 3
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1

```

 

 **Constraints:** 

- 1 <= nums.length <= 5 * 104
- -231 <= nums[i] <= 231 - 1

## Solution

**Language:** Java  
**Runtime:** 45 ms (beats 40.24%)  
**Memory:** 64.2 MB (beats 31.47%)  
**Submitted:** 2026-11-27T05:30:49.334Z  

```java
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {

        if(low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;

        int count = mergeSort(nums, low, mid);

        count += mergeSort(nums, mid + 1, high);

        count += countPairs(nums, low, mid, high);

        merge(nums, low, mid, high);

        return count;
    }

    private int countPairs(int[] nums, int low, int mid, int high) {

        int right = mid + 1;
        int count = 0;

        for(int i=low; i<=mid; i++) {
            
            while(right <= high && (long) nums[i] > 2L * nums[right]) {
                right++;
            }

            count += right - (mid + 1);
        }

        return count;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int i = low, j = mid + 1, x = 0;

        while(i <= mid && j <= high) {
            
            if(nums[i] <= nums[j]) {
                temp[x++] = nums[i++];
            } else {
                temp[x++] = nums[j++];
            }
        }

        while(i <= mid) {
            temp[x++] = nums[i++];
        }

        while(j <= high) {
            temp[x++] = nums[j++];
        }

        for(int k=0; k<temp.length; k++) {
            nums[low + k] = temp[k];
        }
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/reverse-pairs/)