# Minimum Window Substring

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given two strings `s` and `t` of lengths `m` and `n` respectively, return  *the  **minimum window***   ***substring**  **of  *`s`*  such that every character in  *`t`*  (** including duplicates**) is included in the window *. If there is no such substring, return* the empty string *`""`.

The testcases will be generated such that the answer is  **unique**.

 

 **Example 1:** 

```
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

```

 **Example 2:** 

```
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

```

 **Example 3:** 

```
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.

```

 

 **Constraints:** 

- m == s.length
- n == t.length
- 1 <= m, n <= 105
- s and t consist of uppercase and lowercase English letters.

 

 **Follow up:**  Could you find an algorithm that runs in `O(m + n)` time?

## Solution

**Language:** Java  
**Runtime:** 20 ms (beats 36.82%)  
**Memory:** 47.6 MB (beats 25.40%)  
**Submitted:** 2026-10-24T06:58:36.397Z  

```java
class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();

        if(m < n) return "";

        Map<Character, Integer> required = new HashMap<>();
        for(char ch : t.toCharArray()) {
            required.put(ch, required.getOrDefault(ch, 0) + 1);
        }

        int i = 0;
        int formed = 0, start = 0, min = Integer.MAX_VALUE;
        StringBuilder str = new StringBuilder();
        Map<Character, Integer> window = new HashMap<>();

        for(int j=0; j<m; j++)
        {
            char ch = s.charAt(j);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if(required.containsKey(ch) && window.get(ch).intValue() == required.get(ch).intValue()) {
                formed++;
            }

            while(formed == required.size())
            {
                int len = j - i + 1;

                if(len < min) {
                    min = len;
                    start = i;
                }

                char leftCh = s.charAt(i++);
                window.put(leftCh, window.get(leftCh) - 1);

                if(required.containsKey(leftCh) && window.get(leftCh) < required.get(leftCh)) {
                    formed--;
                }
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-window-substring/)