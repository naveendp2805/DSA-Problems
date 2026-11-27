# Q1. Beautiful Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

An array `nums` of length `n` is  **beautiful**  if:

- nums is a permutation of the integers in the range [1, n].
- For every 0 <= i < j < n, there is no index k with i < k < j where 2 * nums[k] == nums[i] + nums[j].

Given the integer `n`, return  *any  **beautiful**  array* `nums` *of length* `n`. There will be at least one valid answer for the given `n`.

 

Original
Java
 **Example 1:** 

```
Input: n = 4
Output: [2,1,4,3]

```

 **Example 2:** 

```
Input: n = 5
Output: [3,1,2,5,4]

```

 

 **Constraints:** 

- 1 <= n <= 1000

## Solution

**Language:** Java  
**Runtime:** 7 ms (beats 5.89%)  
**Memory:** 43.6 MB (beats 35.35%)  
**Submitted:** 2026-11-27T04:53:33.482Z  

```java
class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);

        while(res.size() < n) {
            List<Integer> temp = new ArrayList<>();

            for(int x : res) {
                int odd = 2 * x - 1;

                if(odd <= n) {
                    temp.add(odd);
                }
            }

            for(int x : res) {
                int even = 2 * x;

                if(even <= n) {
                    temp.add(even);
                }
            }

            res = temp;
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/beautiful-array/)