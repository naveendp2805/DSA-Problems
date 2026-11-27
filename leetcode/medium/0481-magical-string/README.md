# Q3. Magical String

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A magical string `s` consists of only `'1'` and `'2'` and obeys the following rule:

- Concatenating the sequence of lengths of its consecutive groups of identical characters '1' and '2' generates the string s itself.

The first few elements of `s` is `s = "1221121221221121122……"`. If we group the consecutive `1`'s and `2`'s in `s`, it will be `"1 22 11 2 1 22 1 22 11 2 11 22......"` and counting the occurrences of `1`'s or `2`'s in each group yields the sequence `"1 2 2 1 1 2 1 2 2 1 2 2......"`.

You can see that concatenating the occurrence sequence gives us `s` itself.

Given an integer `n`, return the number of `1`'s in the first `n` number in the magical string `s`.

 

Original
Java
 **Example 1:** 

```
Input: n = 6
Output: 3
Explanation: The first 6 elements of magical string s is "122112" and it contains three 1's, so return 3.

```

 **Example 2:** 

```
Input: n = 1
Output: 1

```

 

 **Constraints:** 

- 1 <= n <= 105

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 79.32%)  
**Memory:** 43.6 MB (beats 64.14%)  
**Submitted:** 2026-11-27T05:51:40.317Z  

```java
class Solution {
    public int magicalString(int n) {
        if(n == 0) return 0;
        if(n <= 3) return 1;

        int[] arr = new int[n];

        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 2;

        int count = 1;

        int i=2, j=3, num = 1;

        while(j < n) 
        {
            for(int k=0; k<arr[i] && j<n; k++) 
            {

                arr[j] = num;

                if(num == 1) {
                    count++;
                }

                j++;
            }

            num = 3 - num;

            i++;
        }

        return count;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/magical-string/)