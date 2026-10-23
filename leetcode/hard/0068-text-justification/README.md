# Text Justification

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an array of strings `words` and a width `maxWidth`, format the text such that each line has exactly `maxWidth` characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces `' '` when necessary so that each line has exactly `maxWidth` characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

 **Note:** 

- A word is defined as a character sequence consisting of non-space characters only.
- Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
- The input array words contains at least one word.

 

 **Example 1:** 

```
Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
```

 **Example 2:** 

```
Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified because it contains only one word.
```

 **Example 3:** 

```
Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
```

 

 **Constraints:** 

- 1 <= words.length <= 300
- 1 <= words[i].length <= 20
- words[i] consists of only English letters and symbols.
- 1 <= maxWidth <= 100
- words[i].length <= maxWidth

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.8 MB (beats 94.22%)  
**Submitted:** 2026-10-23T05:52:44.345Z  

```java
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length, i = 0;
        List<String> res = new ArrayList<>();

        while(i < n)
        {
            int j = i, len = 0;

            while(j < n && len + words[j].length() + (j - i) <= maxWidth)
            {
                len += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            int spaces = maxWidth - len;

            StringBuilder line = new StringBuilder();

            if(j == n || gaps == 0)
            {
                for(int k=i; k<j; k++)
                {
                    line.append(words[k]);
                    if(k != j-1)
                        line.append(" ");
                }

                while(line.length() < maxWidth)
                    line.append(" ");
            }
            else
            {
                int spaceEach = spaces / gaps;
                int extra = spaces % gaps;

                for(int k=i; k<j; k++)
                {
                    line.append(words[k]);

                    if(k != j-1)
                    {
                        int toAdd = spaceEach + (extra-- > 0 ? 1 : 0);
                        line.append(" ".repeat(toAdd));
                    }
                }
            }

            res.add(line.toString());
            i = j;
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/text-justification/)