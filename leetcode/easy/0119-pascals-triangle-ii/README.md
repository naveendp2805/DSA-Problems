# Pascal's Triangle II

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an integer `rowIndex`, return the `rowIndexth` (**0-indexed**) row of the  **Pascal's triangle**.

In  **Pascal's triangle**, each number is the sum of the two numbers directly above it as shown:

 

 **Example 1:** 

```
Input: rowIndex = 3
Output: [1,3,3,1]

```

 **Example 2:** 

```
Input: rowIndex = 0
Output: [1]

```

 **Example 3:** 

```
Input: rowIndex = 1
Output: [1,1]

```

 

 **Constraints:** 

- 0 <= rowIndex <= 33

 

 **Follow up:**  Could you optimize your algorithm to use only `O(rowIndex)` extra space?

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 69.26%)  
**Memory:** 42.5 MB (beats 71.48%)  
**Submitted:** 2026-09-23T15:36:26.392Z  

```java
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);

        for(int i=1; i<=rowIndex; i++)
        {
            for(int j=i-1; j>0; j--) {
                res.set(j, res.get(j) + res.get(j-1));
            }

            res.add(1);
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/pascals-triangle-ii/)