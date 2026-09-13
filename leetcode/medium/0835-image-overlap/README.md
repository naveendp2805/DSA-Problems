# Image Overlap

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given two images, `img1` and `img2`, represented as binary, square matrices of size `n x n`. A binary matrix has only `0`s and `1`s as values.

We  **translate**  one image however we choose by sliding all the `1` bits left, right, up, and/or down any number of units. We then place it on top of the other image. We can then calculate the  **overlap**  by counting the number of positions that have a `1` in  **both**  images.

Note also that a translation does  **not**  include any kind of rotation. Any `1` bits that are translated outside of the matrix borders are erased.

Return  *the largest possible overlap*.

 

 **Example 1:** 

```
Input: img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
Output: 3
Explanation: We translate img1 to right by 1 unit and down by 1 unit.

The number of positions that have a 1 in both images is 3 (shown in red).

```

 **Example 2:** 

```
Input: img1 = [[1]], img2 = [[1]]
Output: 1

```

 **Example 3:** 

```
Input: img1 = [[0]], img2 = [[0]]
Output: 0

```

 

 **Constraints:** 

- n == img1.length == img1[i].length
- n == img2.length == img2[i].length
- 1 <= n <= 30
- img1[i][j] is either 0 or 1.
- img2[i][j] is either 0 or 1.

## Solution

**Language:** Java  
**Runtime:** 18 ms (beats 98.48%)  
**Memory:** 45.1 MB (beats 52.27%)  
**Submitted:** 2026-09-13T07:37:03.389Z  

```java
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        List<int[]> img1_1s = new ArrayList<>();
        List<int[]> img2_1s = new ArrayList<>();

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(img1[i][j] == 1) img1_1s.add(new int[]{i, j});
                if(img2[i][j] == 1) img2_1s.add(new int[]{i, j});
            }
        }

        int res = 0;
        int[][] pairsCount = new int[2*n][2*n];

        for(int[] l : img1_1s)
        {
            for(int[] r : img2_1s)
            {
                int dx = r[0] - l[0] + n;
                int dy = r[1] - l[1] + n;

                res = Math.max(res, ++pairsCount[dx][dy]);
            }
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/image-overlap/)