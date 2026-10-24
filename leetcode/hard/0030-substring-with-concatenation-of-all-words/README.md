# Substring with Concatenation of All Words

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a string `s` and an array of strings `words`. All the strings of `words` are of  **the same length**.

A  **concatenated string**  is a string that exactly contains all the strings of any permutation of `words` concatenated.

- For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.

Return an array of  *the starting indices*  of all the concatenated substrings in `s`. You can return the answer in  **any order**.

 

 **Example 1:** 

 **Input:**  s = "barfoothefoobarman", words = ["foo","bar"]

 **Output:**  [0,9]

 **Explanation:** 

The substring starting at 0 is `"barfoo"`. It is the concatenation of `["bar","foo"]` which is a permutation of `words`.
The substring starting at 9 is `"foobar"`. It is the concatenation of `["foo","bar"]` which is a permutation of `words`.

 **Example 2:** 

 **Input:**  s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]

 **Output:**  []

 **Explanation:** 

There is no concatenated substring.

 **Example 3:** 

 **Input:**  s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]

 **Output:**  [6,9,12]

 **Explanation:** 

The substring starting at 6 is `"foobarthe"`. It is the concatenation of `["foo","bar","the"]`.
The substring starting at 9 is `"barthefoo"`. It is the concatenation of `["bar","the","foo"]`.
The substring starting at 12 is `"thefoobar"`. It is the concatenation of `["the","foo","bar"]`.

 

 **Constraints:** 

- 1 <= s.length <= 104
- 1 <= words.length <= 5000
- 1 <= words[i].length <= 30
- s and words[i] consist of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 13 ms (beats 19.81%)  
**Memory:** 46.4 MB (beats 99.25%)  
**Submitted:** 2026-10-24T06:36:26.936Z  

```java
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        int wordLen = words[0].length();
        int wordCount = words.length;
        int n = s.length();

        Map<String, Integer> required = new HashMap<>();
        for(String word : words) {
            required.put(word, required.getOrDefault(word, 0) + 1);
        }

        for(int offset = 0; offset < wordLen; offset++)
        {
            int i = offset;
            int count = 0;
            Map<String, Integer> seen = new HashMap<>();

            for(int j = offset; j+wordLen <= n; j += wordLen)
            {
                String word = s.substring(j, j+wordLen);

                if(!required.containsKey(word))
                {
                    i = j + wordLen;
                    count = 0;
                    seen.clear();
                    continue;
                }

                seen.put(word, seen.getOrDefault(word, 0) + 1);
                count++;

                while(seen.get(word) > required.get(word))
                {
                    String word2 = s.substring(i, i+wordLen);

                    seen.put(word2, seen.get(word2) - 1);
                    count--;
                    i += wordLen;
                }

                if(count == wordCount)
                {
                    res.add(i);

                    String word2 = s.substring(i, i+wordLen);

                    seen.put(word2, seen.get(word2) - 1);
                    count--;
                    i += wordLen;
                }
            }
        }

        return res;    
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/substring-with-concatenation-of-all-words/)