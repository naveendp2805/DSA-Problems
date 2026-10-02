# Day of the Week

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a date, return the corresponding day of the week for that date.

The input is given as three integers representing the `day`, `month` and `year` respectively.

Return the answer as one of the following values `{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}`.

 **Note:**  January 1, 1971 was a Friday.

 

 **Example 1:** 

```
Input: day = 31, month = 8, year = 2019
Output: "Saturday"

```

 **Example 2:** 

```
Input: day = 18, month = 7, year = 1999
Output: "Sunday"

```

 **Example 3:** 

```
Input: day = 15, month = 8, year = 1993
Output: "Sunday"

```

 

 **Constraints:** 

- The given dates are valid dates between the years 1971 and 2100.

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.6 MB (beats 39.03%)  
**Submitted:** 2026-10-02T06:57:49.713Z  

```java
class Solution {
    public String dayOfTheWeek(int d, int m, int y) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        int[] t = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        
        if(m < 3)
            y--;
            
        int day = (y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;
        
        return days[day];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/day-of-the-week/)