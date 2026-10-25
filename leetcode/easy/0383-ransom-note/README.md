# Ransom Note

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two strings `ransomNote` and `magazine`, return `true` *if* `ransomNote` *can be constructed by using the letters from* `magazine` *and* `false` *otherwise*.

Each letter in `magazine` can only be used once in `ransomNote`.

 

 **Example 1:** 

```
Input: ransomNote = "a", magazine = "b"
Output: false

```

 **Example 2:** 

```
Input: ransomNote = "aa", magazine = "ab"
Output: false

```

 **Example 3:** 

```
Input: ransomNote = "aa", magazine = "aab"
Output: true

```

 

 **Constraints:** 

- 1 <= ransomNote.length, magazine.length <= 105
- ransomNote and magazine consist of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 58.68%)  
**Memory:** 45.9 MB (beats 95.37%)  
**Submitted:** 2026-10-25T06:50:13.405Z  

```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];

        for(char ch : magazine.toCharArray()) {
            freq[ch - 'a']++;
        }

        for(char ch : ransomNote.toCharArray()) {
            if(freq[ch - 'a'] == 0) return false;
            freq[ch - 'a']--;
        }

        return true;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/ransom-note/)