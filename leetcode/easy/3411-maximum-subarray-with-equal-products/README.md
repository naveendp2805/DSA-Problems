# Maximum Subarray With Equal Products

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given an array of  **positive**  integers `nums`.

An array `arr` is called  **product equivalent**  if `prod(arr) == lcm(arr) * gcd(arr)`, where:

- prod(arr) is the product of all elements of arr.
- gcd(arr) is the GCD of all elements of arr.
- lcm(arr) is the LCM of all elements of arr.

Return the length of the  **longest**   **product equivalent**  subarray of `nums`.

 

Original
Java
 **Example 1:** 

 **Input:**  nums = [1,2,1,2,1,1,1]

 **Output:**  5

 **Explanation:**  

The longest product equivalent subarray is `[1, 2, 1, 1, 1]`, where `prod([1, 2, 1, 1, 1]) = 2`, `gcd([1, 2, 1, 1, 1]) = 1`, and `lcm([1, 2, 1, 1, 1]) = 2`.

 **Example 2:** 

 **Input:**  nums = [2,3,4,5,6]

 **Output:**  3

 **Explanation:**  

The longest product equivalent subarray is `[3, 4, 5].`

 **Example 3:** 

 **Input:**  nums = [1,2,3,1,4,5,1]

 **Output:**  5

 

 **Constraints:** 

- 2 <= nums.length <= 100
- 1 <= nums[i] <= 10

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 82.63%)  
**Memory:** 43.2 MB (beats 98.95%)  
**Submitted:** 2026-11-24T16:31:49.903Z  

```java
class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int res = 1;

        for(int i=0; i<n; i++) {
            long p = nums[i], g = nums[i], l = nums[i];

            for(int j=i+1; j<n; j++) {
                p *= nums[j];
                g = gcd(g, nums[j]);
                l = l * nums[j] / gcd(l, nums[j]);

                if(p > g * l) break;

                if(p == g * l) res = Math.max(res, j - i + 1);
            }
        }

        return res;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-subarray-with-equal-products/)