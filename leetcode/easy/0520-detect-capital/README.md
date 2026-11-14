# Q1. Detect Capital

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

We define the usage of capitals in a word to be right when one of the following cases holds:

- All letters in this word are capitals, like "USA".
- All letters in this word are not capitals, like "leetcode".
- Only the first letter in this word is capital, like "Google".

Given a string `word`, return `true` if the usage of capitals in it is right.

 

Original
Java
 **Example 1:** 

```
Input: word = "USA"
Output: true

```

 **Example 2:** 

```
Input: word = "FlaG"
Output: false

```

 

 **Constraints:** 

- 1 <= word.length <= 100
- word consists of lowercase and uppercase English letters.

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 92.85%)  
**Memory:** 42.2 MB (beats 99.35%)  
**Submitted:** 2026-11-14T06:39:55.455Z  

```java
class Solution {
    public boolean detectCapitalUse(String word) {
        int upper = 0;

        for(char ch : word.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                upper++;
            }
        }

        if(upper == word.length() || upper == 0) {
            return true;
        }

        if(upper == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }

        return false;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/detect-capital/)