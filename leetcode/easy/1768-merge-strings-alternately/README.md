# Merge Strings Alternately

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given two strings `word1` and `word2`. Merge the strings by adding letters in alternating order, starting with `word1`. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return  *the merged string.* 

 

 **Example 1:** 

```
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r

```

 **Example 2:** 

```
Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b 
word2:    p   q   r   s
merged: a p b q   r   s

```

 **Example 3:** 

```
Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q 
merged: a p b q c   d

```

 

 **Constraints:** 

- 1 <= word1.length, word2.length <= 100
- word1 and word2 consist of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 95.74%)  
**Memory:** 43.3 MB (beats 35.41%)  
**Submitted:** 2026-09-24T06:08:24.514Z  

```java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int i=0, j=0;

        StringBuilder res = new StringBuilder();

        while(i < n1 && j < n2)
        {
            res.append(word1.charAt(i++));
            res.append(word2.charAt(j++));
        }

        while(i < n1)
            res.append(word1.charAt(i++));

        while(j < n2)
            res.append(word2.charAt(j++));

        return res.toString();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/merge-strings-alternately/)