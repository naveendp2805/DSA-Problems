# Word Pattern

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a `pattern` and a string `s`, find if `s` follows the same pattern.

Here  **follow**  means a full match, such that there is a bijection between a letter in `pattern` and a  **non-empty**  word in `s`. Specifically:

- Each letter in pattern maps to exactly one unique word in s.
- Each unique word in s maps to exactly one letter in pattern.
- No two letters map to the same word, and no two words map to the same letter.

 

 **Example 1:** 

 **Input:**  pattern = "abba", s = "dog cat cat dog"

 **Output:**  true

 **Explanation:** 

The bijection can be established as:

- 'a' maps to "dog".
- 'b' maps to "cat".

 **Example 2:** 

 **Input:**  pattern = "abba", s = "dog cat cat fish"

 **Output:**  false

 **Example 3:** 

 **Input:**  pattern = "aaaa", s = "dog cat cat dog"

 **Output:**  false

 

 **Constraints:** 

- 1 <= pattern.length <= 300
- pattern contains only lower-case English letters.
- 1 <= s.length <= 3000
- s contains only lowercase English letters and spaces ' '.
- s does not contain any leading or trailing spaces.
- All the words in s are separated by a single space.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 13.80%)  
**Memory:** 42.4 MB (beats 89.51%)  
**Submitted:** 2026-10-28T10:03:06.067Z  

```java
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s+");
        Map<String, Character> map1 = new HashMap<>();
        Map<Character, String> map2 = new HashMap<>();

        int n = pattern.length();

        if(n != words.length)
            return false;

        for(int i=0; i<n; i++)
        {
            String curr = words[i];
            char ch = pattern.charAt(i);

            if(map1.containsKey(curr) && map1.get(curr) != ch)
                return false;

            if(map2.containsKey(ch) && !map2.get(ch).equals(curr))
                return false;

            map1.put(curr, ch);
            map2.put(ch, curr);
        }

        return true;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/word-pattern/)