# Ways to Make a Fair Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer array `nums`. You can choose  **exactly one**  index (**0-indexed**) and remove the element. Notice that the index of the elements may change after the removal.

For example, if `nums = [6,1,7,4,1]`:

- Choosing to remove index 1 results in nums = [6,7,4,1].
- Choosing to remove index 2 results in nums = [6,1,4,1].
- Choosing to remove index 4 results in nums = [6,1,7,4].

An array is  **fair**  if the sum of the odd-indexed values equals the sum of the even-indexed values.

Return the  ***number**  of indices that you could choose such that after the removal,  *`nums`* is  **fair**. *

 

 **Example 1:** 

```
Input: nums = [2,1,6,4]
Output: 1
Explanation:
Remove index 0: [1,6,4] -> Even sum: 1 + 4 = 5. Odd sum: 6. Not fair.
Remove index 1: [2,6,4] -> Even sum: 2 + 4 = 6. Odd sum: 6. Fair.
Remove index 2: [2,1,4] -> Even sum: 2 + 4 = 6. Odd sum: 1. Not fair.
Remove index 3: [2,1,6] -> Even sum: 2 + 6 = 8. Odd sum: 1. Not fair.
There is 1 index that you can remove to make nums fair.

```

 **Example 2:** 

```
Input: nums = [1,1,1]
Output: 3
Explanation: You can remove any index and the remaining array is fair.

```

 **Example 3:** 

```
Input: nums = [1,2,3]
Output: 0
Explanation: You cannot make a fair array after removing any index.

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- 1 <= nums[i] <= 104

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 100.00%)  
**Memory:** 76.2 MB (beats 23.99%)  
**Submitted:** 2026-08-31T07:08:32.501Z  

```java
class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length, res = 0;
        int total_even_sum = 0, total_odd_sum = 0;

        for(int i=0; i<n; i++)
        {
            if((i & 1) == 0) total_even_sum += nums[i];
            else total_odd_sum += nums[i];
        }

        int even_sum = 0, odd_sum = 0;

        for(int i=0; i<n; i++)
        {
            if((i & 1) == 0)
            {
                int new_even_sum = total_odd_sum - odd_sum;
                int new_odd_sum = total_even_sum - (even_sum + nums[i]);

                if(even_sum + new_even_sum == odd_sum + new_odd_sum) 
                    res++;

                even_sum += nums[i];
            } 
            else
            {
                int new_even_sum = total_odd_sum - (odd_sum + nums[i]);
                int new_odd_sum = total_even_sum - even_sum;

                if(even_sum + new_even_sum == odd_sum + new_odd_sum)
                    res++;

                odd_sum += nums[i];
            }
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/ways-to-make-a-fair-array/)