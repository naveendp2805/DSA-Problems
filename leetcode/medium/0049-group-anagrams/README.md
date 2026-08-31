# Group Anagrams

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of strings `strs`, group the anagrams together. You can return the answer in  **any order**.

 

 **Example 1:** 

 **Input:**  strs = ["eat","tea","tan","ate","nat","bat"]

 **Output:**  [["bat"],["nat","tan"],["ate","eat","tea"]]

 **Explanation:** 

- There is no string in strs that can be rearranged to form "bat".
- The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
- The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

 **Example 2:** 

 **Input:**  strs = [""]

 **Output:**  [[""]]

 **Example 3:** 

 **Input:**  strs = ["a"]

 **Output:**  [["a"]]

 

 **Constraints:** 

- 1 <= strs.length <= 104
- 0 <= strs[i].length <= 100
- strs[i] consists of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 8 ms (beats 34.51%)  
**Memory:** 49.9 MB (beats 25.74%)  
**Submitted:** 2026-08-31T07:22:17.767Z  

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs)
        {
            String lexString = convertLexString(str);

            map.computeIfAbsent(lexString, k -> new ArrayList<>()).add(str);
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet())
            res.add(entry.getValue());

        return res;
    }

    private static String convertLexString(String str)
    {
        char[] arr = str.toCharArray();

        Arrays.sort(arr);

        return new String(arr);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/group-anagrams/)