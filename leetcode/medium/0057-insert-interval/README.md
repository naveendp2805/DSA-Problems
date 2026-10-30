# Insert Interval

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an array of non-overlapping intervals `intervals` where `intervals[i] = [starti, endi]` represent the start and the end of the `ith` interval and `intervals` is sorted in ascending order by `starti`. You are also given an interval `newInterval = [start, end]` that represents the start and end of another interval.

Two intervals are considered overlapping if they share  **at least**  one point.

Insert `newInterval` into `intervals` such that `intervals` is still sorted in ascending order by `starti` and `intervals` still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return `intervals` *after the insertion*.

 **Note**  that you don't need to modify `intervals` in-place. You can make a new array and return it.

 

 **Example 1:** 

```
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

```

 **Example 2:** 

```
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

```

 

 **Constraints:** 

- 0 <= intervals.length <= 104
- intervals[i].length == 2
- 0 <= starti <= endi <= 105
- intervals is sorted by starti in ascending order.
- newInterval.length == 2
- 0 <= start <= end <= 105

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 13.61%)  
**Memory:** 46.6 MB (beats 90.24%)  
**Submitted:** 2026-10-30T12:44:54.333Z  

```java
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length + 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int[] interval : intervals) {
            pq.add(interval);
        }

        pq.add(newInterval);

        int[] prev = pq.poll();
        List<int[]> res = new ArrayList<>();

        while(!pq.isEmpty())
        {
            int[] curr = pq.poll();

            if(curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                res.add(prev);
                prev = curr;
            }
        }

        res.add(prev);

        return res.toArray(new int[res.size()][]);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/insert-interval/)