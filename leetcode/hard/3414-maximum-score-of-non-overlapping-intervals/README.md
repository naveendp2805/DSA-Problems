# Maximum Score of Non-overlapping Intervals

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a 2D integer array `intervals`, where `intervals[i] = [li, ri, weighti]`. Interval `i` starts at position `li` and ends at `ri`, and has a weight of `weighti`. You can choose  *up to*  4  **non-overlapping**  intervals. The  **score**  of the chosen intervals is defined as the total sum of their weights.

Return the lexicographically smallest array of at most 4 indices from `intervals` with  **maximum**  score, representing your choice of non-overlapping intervals.

Two intervals are said to be  **non-overlapping**  if they do not share any points. In particular, intervals sharing a left or right boundary are considered overlapping.

 

 **Example 1:** 

 **Input:**  intervals = [[1,3,2],[4,5,2],[1,5,5],[6,9,3],[6,7,1],[8,9,1]]

 **Output:**  [2,3]

 **Explanation:** 

You can choose the intervals with indices 2, and 3 with respective weights of 5, and 3.

 **Example 2:** 

 **Input:**  intervals = [[5,8,1],[6,7,7],[4,7,3],[9,10,6],[7,8,2],[11,14,3],[3,5,5]]

 **Output:**  [1,3,5,6]

 **Explanation:** 

You can choose the intervals with indices 1, 3, 5, and 6 with respective weights of 7, 6, 3, and 5.

 

 **Constraints:** 

- 1 <= intevals.length <= 5 * 104
- intervals[i].length == 3
- intervals[i] = [li, ri, weighti]
- 1 <= li <= ri <= 109
- 1 <= weighti <= 109

## Solution

**Language:** Java  
**Runtime:** 181 ms (beats 29.63%)  
**Memory:** 190.4 MB (beats 38.89%)  
**Submitted:** 2026-09-12T05:49:34.249Z  

```java
class Solution {

    static class State {
        long score;
        List<Integer> indices;

        State(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    private State better(State a, State b) {
        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        // Same score -> lexicographically smaller indices
        return compareLexicographically(a.indices, b.indices) <= 0 ? a : b;
    }

    private int compareLexicographically(List<Integer> a, List<Integer> b) {
        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        return Integer.compare(a.size(), b.size());
    }

    private void addIndex(List<Integer> list, int index) {
        list.add(index);
        Collections.sort(list);
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        // [start, end, weight, originalIndex]
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by start
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(a[1], b[1]);
        });

        // next[i] = first interval whose start > arr[i][1]
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = findNext(arr, i + 1, arr[i][1]);
        }

        // dp[i][k]
        State[][] dp = new State[n + 1][5];

        // Base case
        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new State(0, new ArrayList<>());
        }

        for (int i = n - 1; i >= 0; i--) {

            for (int k = 1; k <= 4; k++) {

                // Option 1: skip
                State skip = dp[i + 1][k];

                // Option 2: take
                State takeNext = dp[next[i]][k - 1];

                List<Integer> takeIndices =
                        new ArrayList<>(takeNext.indices);

                addIndex(takeIndices, arr[i][3]);

                State take = new State(
                        arr[i][2] + takeNext.score,
                        takeIndices
                );

                dp[i][k] = better(skip, take);
            }

            // k = 0
            dp[i][0] = new State(0, new ArrayList<>());
        }

        List<Integer> answer = dp[0][4].indices;

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    private int findNext(int[][] arr, int left, int end) {

        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid][0] > end) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-score-of-non-overlapping-intervals/)