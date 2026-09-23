# Pascal's Triangle

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an integer `numRows`, return the first numRows of  **Pascal's triangle**.

In  **Pascal's triangle**, each number is the sum of the two numbers directly above it as shown:

 

 **Example 1:** 

```
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

```

 **Example 2:** 

```
Input: numRows = 1
Output: [[1]]

```

 

 **Constraints:** 

- 1 <= numRows <= 30

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 95.46%)  
**Memory:** 43.3 MB (beats 85.66%)  
**Submitted:** 2026-09-23T15:44:34.324Z  

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);

        res.add(new ArrayList<>(list));

        for(int i=1; i<numRows; i++)
        {

            for(int j=i-1; j>0; j--)
                list.set(j, list.get(j) + list.get(j-1));

            list.add(1);

            res.add(new ArrayList<>(list));
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/pascals-triangle/)