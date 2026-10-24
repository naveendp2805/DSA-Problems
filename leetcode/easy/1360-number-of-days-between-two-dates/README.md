# Number of Days Between Two Dates

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Write a program to count the number of days between two dates.

The two dates are given as strings, their format is `YYYY-MM-DD` as shown in the examples.

 

 **Example 1:** 

```
Input: date1 = "2019-06-29", date2 = "2019-06-30"
Output: 1

```

 **Example 2:** 

```
Input: date1 = "2020-01-15", date2 = "2019-12-31"
Output: 15

```

 

 **Constraints:** 

- The given dates are valid dates between the years 1971 and 2100.

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 97.67%)  
**Memory:** 42.3 MB (beats 98.31%)  
**Submitted:** 2026-10-24T05:37:16.410Z  

```java
class Solution {
    private final int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(convertToDays(date1) - convertToDays(date2));
    }

    private int convertToDays(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int res = day;

        for (int y = 1971; y < year; y++) {
            res += isLeapYear(y) ? 366 : 365;
        }

        for(int i=0; i<month-1; i++) {
            res += days[i];
        }

        if (month > 2 && isLeapYear(year)) {
            res++;
        }

        return res;
    }

    private boolean isLeapYear(int year) {
        return (year % 400 == 0) ||
               (year % 4 == 0 && year % 100 != 0);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/number-of-days-between-two-dates/)