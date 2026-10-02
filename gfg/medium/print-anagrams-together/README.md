# Arrange Anagrams Together

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**  of strings, group all anagrams together. Two strings are anagrams if they contain the same characters with the same frequencies, possibly in a different order.

Return a 2D array, where each inner array contains a group of anagrams. The relative order of strings within each group should be the same as their order in arr.

 **Examples:** 

```
Input: arr[] = ["act", "god", "cat", "dog", "tac"]
Output: [["act", "cat", "tac"], ["god", "dog"]]
Explanation: There are 2 groups of anagrams "god", "dog" make group 1. "act", "cat", "tac" make group 2.

```

```
Input: arr[] = ["no", "on", "is"]
Output: [["is"], ["no", "on"]]
Explanation: There are 2 groups of anagrams "is" makes group 1. "no", "on" make group 2.
```

```
Input: arr[] = ["listen", "silent", "enlist", "abc", "cab", "bac", "rat", "tar", "art"]
Output: [["abc", "cab", "bac"], ["listen", "silent", "enlist"], ["rat", "tar", "art"]]
Explanation: 
Group 1: "abc", "bac", and "cab" are anagrams.
Group 2: "listen", "silent", and "enlist" are anagrams.
Group 3: "rat", "tar", and "art" are anagrams
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-02T07:11:02.055Z  

```java
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] strs) {
        // code here
        ArrayList<ArrayList<String>> res = new ArrayList<>();

        Map<String, ArrayList<String>> map = new HashMap<>();

        for(String str : strs)
        {
            String lexString = convertToLexString(str);

            map.computeIfAbsent(lexString, k -> new ArrayList<>()).add(str);
        }

        for(ArrayList<String> value : map.values())
            res.add(value);

        return res;
    }

    private static String convertToLexString(String s)
    {
        char[] chars = s.toCharArray();

        Arrays.sort(chars);

        return new String(chars);
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/print-anagrams-together/1)