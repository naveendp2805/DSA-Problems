# Candy

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

There are `n` children standing in a line.

Each child is assigned a rating value given in the integer array `ratings`.

You are giving candies to these children subjected to the following requirements:

- Each child must have at least one candy.
- Children with a higher rating get more candies than their neighbors.

Return the  **minimum**  number of candies you need to have to distribute the candies to the children.

 

 **Example 1:** 

```
Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

```

 **Example 2:** 

```
Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.

```

 

 **Constraints:** 

- 1 <= n == ratings.length <= 5 * 104
- 0 <= ratings[i] <= 5 * 104

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 23.10%)  
**Memory:** 51.7 MB (beats 96.28%)  
**Submitted:** 2026-10-22T15:38:33.671Z  

```java
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for(int i=1; i<n; i++) {
            left[i] = ratings[i] > ratings[i-1] ? left[i-1] + 1 : 1;
        }

        right[n-1] = 1;
        for(int i=n-2; i>=0; i--) {
            right[i] = ratings[i] > ratings[i+1] ? right[i+1] + 1 : 1;
        }

        int res = 0;
        for(int i=0; i<n; i++) {
            res += Math.max(left[i], right[i]);
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/candy/)