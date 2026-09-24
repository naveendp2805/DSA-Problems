# Unique Number of Occurrences

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array of integers `arr`, return `true`  *if the number of occurrences of each value in the array is  **unique**  or* `false` *otherwise*.

 

 **Example 1:** 

```
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
```

 **Example 2:** 

```
Input: arr = [1,2]
Output: false

```

 **Example 3:** 

```
Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true

```

 

 **Constraints:** 

- 1 <= arr.length <= 1000
- -1000 <= arr[i] <= 1000

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 97.99%)  
**Memory:** 43.5 MB (beats 69.48%)  
**Submitted:** 2026-09-24T15:27:39.293Z  

```java
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for(int num : arr)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        Set<Integer> uniqueOcc = new HashSet<>();
        for(int value : freq.values())
        {
            if(!uniqueOcc.add(value))
                return false;
        }
            
        return true;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/unique-number-of-occurrences/)