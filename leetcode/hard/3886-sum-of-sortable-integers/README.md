# Sum of Sortable Integers

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an integer array `nums` of length `n`.

An integer `k` is called  **sortable**  if `k`  **divides**  `n` and you can sort `nums` in  **non-decreasing**  order by sequentially performing the following operations:

- Partition nums into consecutive subarrays of length k.
- Cyclically rotate each subarray independently any number of times to the left or to the right.

Return an integer denoting the sum of all possible sortable integers `k`.

 

 **Example 1:** 

 **Input:**  nums = [3,1,2]

 **Output:**  3

 **Explanation:** ​​​​​​​

- For n = 3, possible divisors are 1 and 3.
- For k = 1: each subarray has one element. No rotation can sort the array.
- For k = 3: the single subarray [3, 1, 2] can be rotated once to produce [1, 2, 3], which is sorted.
- Only k = 3 is sortable. Hence, the answer is 3.

 **Example 2:** 

 **Input:**  nums = [7,6,5]

 **Output:**  0

 **Explanation:** 

- For n = 3, possible divisors are 1 and 3.
- For k = 1: each subarray has one element. No rotation can sort the array.
- For k = 3: the single subarray [7, 6, 5] cannot be rotated into non-decreasing order.
- No k is sortable. Hence, the answer is 0.

 **Example 3:** 

 **Input:**  nums = [5,8]

 **Output:**  3

 **Explanation:** ​​​​​​​

- For n = 2, possible divisors are 1 and 2.
- Since [5, 8] is already sorted, every divisor is sortable. Hence, the answer is 1 + 2 = 3.

 

 **Constraints:** 

- 1 <= n == nums.length <= 105
- 1 <= nums[i] <= 105

## Solution

**Language:** Java  
**Runtime:** 54 ms (beats 54.55%)  
**Memory:** 70.3 MB (beats 88.64%)  
**Submitted:** 2026-10-20T08:30:28.569Z  

```java
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int res = 0;

        for(int k=1; k<=n; k++)
        {
            if(n % k != 0)
                continue;

            boolean sortable = true;
            int prevMax = Integer.MIN_VALUE;
            
            for(int start = 0; start < n; start += k)
            {
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
                int descents = 0;

                for(int j=0; j<k; j++)
                {
                    int curr = nums[start + j];
                    int next = nums[start + (j + 1) % k];

                    if(curr > next)
                        descents++;

                    min = Math.min(min, curr);
                    max = Math.max(max, curr);
                }

                if(descents > 1 || prevMax > min)
                {
                    sortable = false;
                    break;
                }

                prevMax = max;
            }

            if(sortable)
                res += k;
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/sum-of-sortable-integers/)