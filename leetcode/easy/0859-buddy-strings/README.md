# Buddy Strings

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two strings `s` and `goal`, return `true` *if you can swap two letters in* `s` *so the result is equal to* `goal` *, otherwise, return* `false` *.* 

Swapping letters is defined as taking two indices `i` and `j` (0-indexed) such that `i != j` and swapping the characters at `s[i]` and `s[j]`.

- For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

 

 **Example 1:** 

```
Input: s = "ab", goal = "ba"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.

```

 **Example 2:** 

```
Input: s = "ab", goal = "ab"
Output: false
Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.

```

 **Example 3:** 

```
Input: s = "aa", goal = "aa"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.

```

 

 **Constraints:** 

- 1 <= s.length, goal.length <= 2 * 104
- s and goal consist of lowercase letters.

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 27.47%)  
**Memory:** 44.2 MB (beats 7.57%)  
**Submitted:** 2026-08-28T15:02:56.743Z  

```java
class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;

        int n = s.length();

        if(s.equals(goal))
        {
            Set<Character> set = new HashSet<>();
            for(char ch : s.toCharArray())
                set.add(ch);

            return set.size() < goal.length();
        }

        int i=0, j=n-1;

        while(i < n && s.charAt(i) == goal.charAt(i))
            i++;
        
        while(j >= 0 && s.charAt(j) == goal.charAt(j))
            j--;

        if(i < j)
        {
            char[] arr = s.toCharArray();
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            s = new String(arr);
        }

        return s.equals(goal);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/buddy-strings/)