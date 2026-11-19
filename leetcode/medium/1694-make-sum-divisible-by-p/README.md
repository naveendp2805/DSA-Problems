# Q2. Make Sum Divisible by P

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of positive integers `nums`, remove the  **smallest**  subarray (possibly  **empty**) such that the  **sum**  of the remaining elements is divisible by `p`. It is  **not**  allowed to remove the whole array.

Return  *the length of the smallest subarray that you need to remove, or* `-1` *if it's impossible*.

A  **subarray**  is defined as a contiguous block of elements in the array.

 

Original
Java
 **Example 1:** 

```
Input: nums = [3,1,4,2], p = 6
Output: 1
Explanation: The sum of the elements in nums is 10, which is not divisible by 6. We can remove the subarray [4], and the sum of the remaining elements is 6, which is divisible by 6.

```

 **Example 2:** 

```
Input: nums = [6,3,5,2], p = 9
Output: 2
Explanation: We cannot remove a single element to get a sum divisible by 9. The best way is to remove the subarray [5,2], leaving us with [6,3] with sum 9.

```

 **Example 3:** 

```
Input: nums = [1,2,3], p = 3
Output: 0
Explanation: Here the sum is 6. which is already divisible by 3. Thus we do not need to remove anything.

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- 1 <= nums[i] <= 109
- 1 <= p <= 109

## Solution

**Language:** Java  
**Runtime:** 30 ms (beats 34.65%)  
**Memory:** 98.8 MB (beats 56.92%)  
**Submitted:** 2026-11-19T07:00:03.132Z  

```java
class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long totalSum = 0;

        for(int num : nums) {
            totalSum += num;
        }

        int target = (int) (totalSum % p);

        if(target == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        long prefixSum = 0;
        int minLen = n;

        for(int i=0; i<n; i++)
        {
            prefixSum += nums[i];

            int rem = (int) (prefixSum % p);
            int req = (rem - target + p) % p;

            if(map.containsKey(req)) {
                int len = i - map.get(req);
                minLen = Math.min(len, minLen);
            }

            map.put(rem, i);
        }

        return minLen == n ? -1 : minLen;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/make-sum-divisible-by-p/)