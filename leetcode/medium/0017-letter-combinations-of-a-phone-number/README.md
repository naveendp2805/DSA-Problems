# Letter Combinations of a Phone Number

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string containing digits from `2-9` inclusive, return all possible letter combinations that the number could represent. Return the answer in  **any order**.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

 

 **Example 1:** 

```
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

```

 **Example 2:** 

```
Input: digits = "2"
Output: ["a","b","c"]

```

 

 **Constraints:** 

- 1 <= digits.length <= 4
- digits[i] is a digit in the range ['2', '9'].

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 43.4 MB (beats 79.09%)  
**Submitted:** 2026-09-14T15:30:59.269Z  

```java
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        buildCombinations(digits, 0, new StringBuilder(), res, map);

        return res;
    }

    private static void buildCombinations(String digits, int idx, StringBuilder combination, List<String> res, Map<Character, String> map)
    {
        if(idx == digits.length())
        {
            res.add(combination.toString());
            return;
        }

        String letters = map.get(digits.charAt(idx));

        for(char letter : letters.toCharArray())
        {
            combination.append(letter);

            buildCombinations(digits, idx+1, combination, res, map);

            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)