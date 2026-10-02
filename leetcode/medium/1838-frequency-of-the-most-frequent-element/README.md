# Frequency of the Most Frequent Element

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

The  **frequency**  of an element is the number of times it occurs in an array.

You are given an integer array `nums` and an integer `k`. In one operation, you can choose an index of `nums` and increment the element at that index by `1`.

Return  *the  **maximum possible frequency**  of an element after performing  **at most*** `k` *operations*.

 

 **Example 1:** 

```
Input: nums = [1,2,4], k = 5
Output: 3
Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
4 has a frequency of 3.
```

 **Example 2:** 

```
Input: nums = [1,4,8,13], k = 5
Output: 2
Explanation: There are multiple optimal solutions:
- Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
- Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
- Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.

```

 **Example 3:** 

```
Input: nums = [3,9,6], k = 2
Output: 1

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- 1 <= nums[i] <= 105
- 1 <= k <= 105

## Solution

**Language:** Java  
**Runtime:** 34 ms (beats 47.44%)  
**Memory:** 94.5 MB (beats 90.22%)  
**Submitted:** 2026-10-02T07:50:04.163Z  

```java
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        long res = 0, sum = 0;
        int i = 0;

        for(int j=0; j<nums.length; j++)
        {
            sum += nums[j];

            while(nums[j] * (j - i + 1L) > (sum + k)) {
                sum -= nums[i++];
            }

            res = Math.max(res, j-i+1L);
        }
        return (int) res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/frequency-of-the-most-frequent-element/)