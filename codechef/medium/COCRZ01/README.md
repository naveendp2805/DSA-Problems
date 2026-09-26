# COCRZ01

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Chef has a list of intervals $intervalList$, where each interval is represented by a start and an end point.
Chef wants to remove the minimum number of intervals so that no two remaining intervals overlap.
Help Chef find the minimum count of intervals that must be removed to achieve this.

#### Note:

An interval is represented as  **[start, end]**, where `start < end`.

Two intervals are considered  **non-overlapping**  if they share  **any common point**. Intervals that touch at endpoints (e.g. `[1,2]` and `[2,3]`) are considered  **non-overlapping**.

The task is to remove the  **minimum number of intervals**  so that no two remaining intervals overlap. This is equivalent to selecting the  **maximum number of non-overlapping intervals**, where an interval can be selected only if its `start` is  **greater**  than or  **equal**  to the `end` of the previously selected interval.

## Function Declaration
### Function Name

$findMinimumRemovals$ — This function determines the minimum number of intervals to remove to eliminate all overlaps in a given list of intervals.

### Parameters
- $intervalList$: A reference to a vector containing intervals, where each interval is represented as a vector of two integers $[start, end]$.
- The intervals represent ranges with integer start and end points.
- Intervals may overlap or touch at endpoints.
### Return Value
- Returns an integer representing the minimum count of intervals that must be removed to ensure no intervals overlap.
### Input Format
- The first line contains a single integer $T$ — the number of test cases.
- Each test case consists of: The first line contains an integer $N$ — the number of intervals Chef has. The next $N$ lines each contain two integers $start_i$ and $end_i$ describing the intervals.
### Output Format
- For each test case, print a single line containing one integer — the minimum number of intervals Chef must remove so that no intervals overlap.
### Constraints
- $1 \leq \ T \leq 10$
- $1 \leq \text{intervalList.size()} \leq 10^4$
- Each interval has exactly two integers: $start$ and $end$
- $-5 \times 10^4 \leq \text{start}_i \lt \text{end}_i \leq 5 \times 10^4$
### Sample 1:
Input
Output

```
3
3
[0 1]
[3 4]
[1 2]
3
[1 2]
[1 3]
[1 4]
3
[1 2]
[1 4]
[2 4]

```

```
0
2
1
```

### Explanation:
- First test case: no need to remove any intervals as all are non overlapping. [0 1] [1 2] [3 4]
- Second test case: we can choose any one of the intervals only as all of them are overlapping thus we have to remove any 2 intervals.
- Third test case: we have to remove [1 4] as it is overlapping the whole interval but by removing it we can have non-overlapping interval: [1 2][2 4].

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-26T05:24:27.638Z  

```java
class Solution {
    public int findMinimumRemovals(List<int[]> intervalList) {
        // write your code here 
        int n = intervalList.size();
        
        Collections.sort(intervalList, (a, b) -> {
            if(a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        
        int prev = intervalList.get(0)[1], res = 0;
        
        for(int i=1; i<n; i++)
        {
            if(intervalList.get(i)[0] < prev)
            {
                res++;
            } else  
                prev = intervalList.get(i)[1];
        }
        
        return res;
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/COCRZ01)