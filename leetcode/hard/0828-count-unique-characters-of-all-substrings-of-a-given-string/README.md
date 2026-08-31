# Count Unique Characters of All Substrings of a Given String

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Let's define a function `countUniqueChars(s)` that returns the number of unique characters in `s`.

- For example, calling countUniqueChars(s) if s = "LEETCODE" then "L", "T", "C", "O", "D" are the unique characters since they appear only once in s, therefore countUniqueChars(s) = 5.

Given a string `s`, return the sum of `countUniqueChars(t)` where `t` is a substring of `s`. The test cases are generated such that the answer fits in a 32-bit integer.

Notice that some substrings can be repeated so in this case you have to count the repeated ones too.

 

 **Example 1:** 

```
Input: s = "ABC"
Output: 10
Explanation: All possible substrings are: "A","B","C","AB","BC" and "ABC".
Every substring is composed with only unique letters.
Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10

```

 **Example 2:** 

```
Input: s = "ABA"
Output: 8
Explanation: The same as example 1, except countUniqueChars("ABA") = 1.

```

 **Example 3:** 

```
Input: s = "LEETCODE"
Output: 92

```

 

 **Constraints:** 

- 1 <= s.length <= 105
- s consists of uppercase English letters only.

## Solution

**Language:** Java  
**Runtime:** 9 ms (beats 70.67%)  
**Memory:** 47.2 MB (beats 52.49%)  
**Submitted:** 2026-08-31T06:28:04.589Z  

```java
class Solution {
    public int uniqueLetterString(String s) {
        int[] prev = new int[26];
        int[] last = new int[26];

        Arrays.fill(prev, -1);
        Arrays.fill(last, -1);

        long res = 0;
        int n = s.length();

        for(int i=0; i<n; i++)
        {
            int ch = s.charAt(i) - 'A';

            if(last[ch] != -1)
            {
                res += (long) (last[ch] - prev[ch]) * (i - last[ch]);
            }

            prev[ch] = last[ch];
            last[ch] = i;
        }

        for(int ch=0; ch<26; ch++)
        {
            if(last[ch] != -1)
            {
                res += (long) (last[ch] - prev[ch]) * (n - last[ch]);
            }
        }

        return (int)res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/)