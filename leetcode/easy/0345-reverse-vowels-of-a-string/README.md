# Reverse Vowels of a String

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a string `s`, reverse only all the vowels in the string and return it.

The vowels are `'a'`, `'e'`, `'i'`, `'o'`, and `'u'`, and they can appear in both lower and upper cases, more than once.

 

 **Example 1:** 

 **Input:**  s = "IceCreAm"

 **Output:**  "AceCreIm"

 **Explanation:** 

The vowels in `s` are `['I', 'e', 'e', 'A']`. On reversing the vowels, s becomes `"AceCreIm"`.

 **Example 2:** 

 **Input:**  s = "leetcode"

 **Output:**  "leotcede"

 

 **Constraints:** 

- 1 <= s.length <= 3 * 105
- s consist of printable ASCII characters.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 98.93%)  
**Memory:** 46.8 MB (beats 21.55%)  
**Submitted:** 2026-09-24T13:08:38.038Z  

```java
class Solution {
    public String reverseVowels(String s) {
        int i=0, j=s.length()-1;
        char[] chars = s.toCharArray();

        while(i < j)
        {
            char ch1 = chars[i], ch2 = chars[j];

            boolean left = isVowel(ch1);
            boolean right = isVowel(ch2);

            if(left && right)
            {
                char temp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = temp; 
            } else if(left)
                j--;
            else i++;
        }

        return new String(chars);
    }

    private static boolean isVowel(char ch)
    {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
            ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            return true;

        return false;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/reverse-vowels-of-a-string/)