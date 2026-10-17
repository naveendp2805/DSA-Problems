# Minimum Swaps to Sort by Digit Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an array `nums` of  **distinct**  positive integers. You need to sort the array in  **increasing**  order based on the sum of the digits of each number. If two numbers have the same digit sum, the  **smaller**  number appears first in the sorted order.

Return the  **minimum**  number of swaps required to rearrange `nums` into this sorted order.

A  **swap**  is defined as exchanging the values at two distinct positions in the array.

 

 **Example 1:** 

 **Input:**  nums = [37,100]

 **Output:**  1

 **Explanation:** 

- Compute the digit sum for each integer: [3 + 7 = 10, 1 + 0 + 0 = 1] → [10, 1]
- Sort the integers based on digit sum: [100, 37]. Swap 37 with 100 to obtain the sorted order.
- Thus, the minimum number of swaps required to rearrange nums is 1.

 **Example 2:** 

 **Input:**  nums = [22,14,33,7]

 **Output:**  0

 **Explanation:** 

- Compute the digit sum for each integer: [2 + 2 = 4, 1 + 4 = 5, 3 + 3 = 6, 7 = 7] → [4, 5, 6, 7]
- Sort the integers based on digit sum: [22, 14, 33, 7]. The array is already sorted.
- Thus, the minimum number of swaps required to rearrange nums is 0.

 **Example 3:** 

 **Input:**  nums = [18,43,34,16]

 **Output:**  2

 **Explanation:** 

- Compute the digit sum for each integer: [1 + 8 = 9, 4 + 3 = 7, 3 + 4 = 7, 1 + 6 = 7] → [9, 7, 7, 7]
- Sort the integers based on digit sum: [16, 34, 43, 18]. Swap 18 with 16, and swap 43 with 34 to obtain the sorted order.
- Thus, the minimum number of swaps required to rearrange nums is 2.

 

 **Constraints:** 

- 1 <= nums.length <= 105
- 1 <= nums[i] <= 109
- nums consists of distinct positive integers.

## Solution

**Language:** Java  
**Runtime:** 262 ms (beats 91.95%)  
**Memory:** 121.3 MB (beats 52.35%)  
**Submitted:** 2026-10-17T05:42:15.119Z  

```java
class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        int[][] arr = new int[n][3];

        for(int i=0; i<n; i++)
        {
            int ele = nums[i];

            arr[i][0] = digitSum(ele);
            arr[i][1] = ele;
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] != b[0]
                                ? Integer.compare(a[0], b[0])
                                : Integer.compare(a[1], b[1])
                    );

        boolean[] visited = new boolean[n];
        int res = 0;

        for(int i=0; i<n; i++)
        {
            if(visited[i] || arr[i][2] == i)
                continue;

            int j = i, len = 0;

            while(!visited[j])
            {
                visited[j] = true;
                j = arr[j][2];
                len++;
            }

            res += len - 1;
        }

        return res;
    }

    private int digitSum(int n)
    {
        int res = 0;

        while(n > 0)
        {
            res += n % 10;
            n /= 10;
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-swaps-to-sort-by-digit-sum/)