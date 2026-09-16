# Sum of Beauty of All Substrings

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

The  **beauty**  of a string is the difference in frequencies between the most frequent and least frequent characters.

- For example, the beauty of "abaacc" is 3 - 1 = 2.

Given a string `s`, return  *the sum of  **beauty**  of all of its substrings.* 

 

 **Example 1:** 

```
Input: s = "aabcb"
Output: 5
Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
```

 **Example 2:** 

```
Input: s = "aabcbaa"
Output: 17

```

 

 **Constraints:** 

- 1 <= s.length <= 500
- s consists of only lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 67 ms (beats 42.21%)  
**Memory:** 43.9 MB (beats 92.32%)  
**Submitted:** 2026-09-16T11:35:30.133Z  

```java
class Solution {
    public int beautySum(String s) {
        int res = 0, n = s.length();

        for(int i=0; i<n; i++)
        {
            int[] freq = new int[26];

            for(int j=i; j<n; j++)
            {
                freq[s.charAt(j) - 'a']++;

                res += findBeauty(freq);
            }
        }

        return res;
    }

    private int findBeauty(int[] freq) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int i=0; i<26; i++)
        {
            if(freq[i] > 0)
            {
                min = Math.min(min, freq[i]);
                max = Math.max(max, freq[i]);
            }
        }

        return max - min;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/sum-of-beauty-of-all-substrings/)