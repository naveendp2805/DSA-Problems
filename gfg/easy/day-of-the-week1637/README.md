# Day of the Week

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array `date[] = [d, m, y]`, where `d` denotes the day, `m` denotes the month, and `y` denotes the year, Write a program that calculates the day of the week for any particular date in the past or future.

 **Examples:** 

```
Input: date[] = [28, 12, 1995]
Output: Thursday
Explanation: 28 December 1995 was a Thursday.
```

```
Input: date[] = [30, 8, 2010]
Output: Monday
Explanation: 30 August 2010 was a Monday.

```

 **Constraints:** 
1 ≤ d ≤ 31
1 ≤ m ≤ 12
1 ≤ y ≤ 2100

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-02T06:57:17.385Z  

```java
class Solution {
    public String getDayOfWeek(int[] date) {
        // code here
        int y = date[2], m = date[1], d = date[0];
        
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        int[] t = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        
        if(m < 3)
            y--;
            
        int day = (y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;
        
        return days[day];
    }
};
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/day-of-the-week1637/1)