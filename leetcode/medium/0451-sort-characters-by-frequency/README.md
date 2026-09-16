# Sort Characters By Frequency

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s`, sort it in  **decreasing order**  based on the  **frequency**  of the characters. The  **frequency**  of a character is the number of times it appears in the string.

Return  *the sorted string*. If there are multiple answers, return  *any of them*.

 

 **Example 1:** 

```
Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

```

 **Example 2:** 

```
Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.

```

 **Example 3:** 

```
Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

```

 

 **Constraints:** 

- 1 <= s.length <= 5 * 105
- s consists of uppercase and lowercase English letters and digits.

## Solution

**Language:** Java  
**Runtime:** 16 ms (beats 40.57%)  
**Memory:** 46.5 MB (beats 63.61%)  
**Submitted:** 2026-09-16T11:10:30.201Z  

```java
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );

        pq.addAll(map.entrySet());

        StringBuilder res = new StringBuilder();
        
        while(!pq.isEmpty())
        {
            Map.Entry<Character, Integer> entry = pq.poll();
            res.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }

        return res.toString();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/sort-characters-by-frequency/)