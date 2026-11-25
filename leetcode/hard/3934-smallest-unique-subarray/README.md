# Smallest Unique Subarray

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an integer array `nums`.

Find the  **minimum** length of a subarray that is  **not**   **identical**  to any other  **subarray**  in `nums`.

Return an integer denoting the  **minimum possible length**  of such a  **subarray**.

Two  **subarrays**  are considered identical if they have the same length and the same elements in corresponding positions.

 

Original
Java
 **Example 1:** 

 **Input:**  nums = [3,3,3]

 **Output:**  3

 **Explanation:** 

- Subarrays of length 1: [3] → appears 3 times
- Subarrays of length 2: [3, 3] → appears 2 times
- Subarrays of length 3: [3, 3, 3] → appears once

The subarray `[3, 3, 3]` is unique, so the smallest unique subarray length is 3.

 **Example 2:** 

 **Input:**  nums = [2,1,2,3,3]

 **Output:**  1

 **Explanation:** 

Subarrays of length 1:

- [2] → appears 2 times
- [1] → appears once
- [3] → appears 2 times
The subarray `[1]` is unique, so the smallest unique subarray length is 1.

 **Example 3:** 

 **Input:**  nums = [1,1,2,2,1]

 **Output:**  2

 **Explanation:** 

Subarrays of length 1:

- [1] → appears 3 times
- [2] → appears 2 times

Subarrays of length 2:

- [1, 1] → appears once
- [1, 2] → appears once
- [2, 2] → appears once
- [2, 1] → appears once
There is at least one subarray of length 2 that is unique, so the smallest unique subarray length is 2.

 

 **Constraints:** 

- 1 <= nums.length <= 105
- 1 <= nums[i] <= 105

## Solution

**Language:** Java  
**Runtime:** 573 ms (beats 32.14%)  
**Memory:** 100.9 MB (beats 87.50%)  
**Submitted:** 2026-11-25T14:45:03.980Z  

```java
class Solution {
    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        // STEP 1: Initialize suffix array
        int[] sa = new int[n];
        int[] rank = nums.clone();

        for (int i = 0; i < n; i++) {
            sa[i] = i;
        }

        // STEP 2: Build suffix array using doubling
        for (int k = 1; k < n; k *= 2) {

            long[] keys = new long[n];

            for (int i = 0; i < n; i++) {

                int first = rank[i] + 1;

                int second = (i + k < n)
                        ? rank[i + k] + 1 : 0;

                keys[i] = ((long) first << 34)
                        | ((long) second << 17)
                        | i;
            }

            Arrays.sort(keys);

            int[] newRank = new int[n];

            for (int i = 0; i < n; i++) {
                sa[i] = (int) (keys[i] & ((1L << 17) - 1));
            }

            int classes = 0;
            newRank[sa[0]] = 0;

            for (int i = 1; i < n; i++) {

                int a = sa[i - 1];
                int b = sa[i];

                int a2 = a + k < n ? rank[a + k] : -1;
                int b2 = b + k < n ? rank[b + k] : -1;

                if (rank[a] != rank[b] || a2 != b2) {
                    classes++;
                }

                newRank[b] = classes;
            }

            rank = newRank;

            if (classes == n - 1) {
                break;
            }
        }

        // STEP 3: Calculate positions
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            pos[sa[i]] = i;
        }

        // STEP 4: Calculate LCP using Kasai algorithm
        int[] lcp = new int[n];

        int h = 0;

        for (int i = 0; i < n; i++) {

            int r = pos[i];

            if (r == 0) {
                h = 0;
                continue;
            }

            int j = sa[r - 1];

            while (i + h < n && j + h < n
                    && nums[i + h] == nums[j + h]) {
                h++;
            }

            lcp[r] = h;

            if (h > 0) {
                h--;
            }
        }

        // STEP 5: Find minimum unique subarray
        int ans = n;

        for (int r = 0; r < n; r++) {

            int left = lcp[r];

            int right = (r + 1 < n)
                    ? lcp[r + 1] : 0;

            int required = Math.max(left, right) + 1;

            int start = sa[r];

            if (start + required <= n) {
                ans = Math.min(ans, required);
            }
        }

        return ans;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/smallest-unique-subarray/)