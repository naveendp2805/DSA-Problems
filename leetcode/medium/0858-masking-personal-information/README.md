# Q3. Masking Personal Information

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a personal information string `s`, representing either an  **email address**  or a  **phone number**. Return  *the  **masked**  personal information using the below rules*.

 **Email address:** 

An email address is:

- A name consisting of at least two uppercase and lowercase English letters, followed by
- The '@' symbol, followed by
- The domain consisting of uppercase and lowercase English letters with a dot '.' somewhere in the middle (not the first or last character).

To mask an email:

- The uppercase letters in the name and domain must be converted to lowercase letters.
- The middle letters of the name (i.e., all but the first and last letters) must be replaced by 5 asterisks "  *".

 **Phone number:** 

A phone number is formatted as follows:

- The phone number contains 10-13 digits.
- The last 10 digits make up the local number.
- The remaining 0-3 digits, in the beginning, make up the country code.
- Separation characters from the set {'+', '-', '(', ')', ' '} separate the above digits in some way.

To mask a phone number:

- Remove all separation characters.
- The masked phone number should have the form: " ***-**  *-XXXX" if the country code has 0 digits. "+* - ***-**  *-XXXX" if the country code has 1 digit. "+ **-*** - ***-XXXX" if the country code has 2 digits. "+**  *- ***-*** -XXXX" if the country code has 3 digits.
- "XXXX" is the last 4 digits of the local number.

 

Original
Java
 **Example 1:** 

```
Input: s = "LeetCode@LeetCode.com"
Output: "l  *e@leetcode.com"
Explanation: s is an email address.
The name and domain are converted to lowercase, and the middle of the name is replaced by 5 asterisks.

```

 **Example 2:** 

```
Input: s = "AB@qq.com"
Output: "a  *b@qq.com"
Explanation: s is an email address.
The name and domain are converted to lowercase, and the middle of the name is replaced by 5 asterisks.
Note that even though "ab" is 2 characters, it still must have 5 asterisks in the middle.

```

 **Example 3:** 

```
Input: s = "1(234)567-890"
Output: " ***-** *-7890"
Explanation: s is a phone number.
There are 10 digits, so the local number is 10 digits and the country code is 0 digits.
Thus, the resulting masked number is " ***-** *-7890".

```

 

 **Constraints:** 

- s is either a valid email or a phone number.
- If s is an email: 8 <= s.length <= 40 s consists of uppercase and lowercase English letters and exactly one '@' symbol and '.' symbol.
- If s is a phone number: 10 <= s.length <= 20 s consists of digits, spaces, and the symbols '(', ')', '-', and '+'.

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 16.20%)  
**Memory:** 48.2 MB (beats 32.41%)  
**Submitted:** 2026-11-14T07:08:34.744Z  

```java
class Solution {
    public String maskPII(String s) {
        
        if(s.contains("@")) {
            s = s.toLowerCase();

            int at = s.indexOf("@");

            String name = s.substring(0, at);
            String domain = s.substring(at);

            return name.charAt(0) + "*****" + name.charAt(name.length() - 1) + domain;
        }

        StringBuilder digits = new StringBuilder();

        for(char digit : s.toCharArray()) {
            if(Character.isDigit(digit)) {
                digits.append(digit);
            }
        }

        int countryCode = digits.length() - 10;
        String lastFour = digits.substring(digits.length() - 4);
        String res = "";

        if (countryCode == 0) {
            res = "***-***-" + lastFour;
        } 
        else {
            res = "+" + "*".repeat(countryCode)
                    + "-***-***-" + lastFour;
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/masking-personal-information/)