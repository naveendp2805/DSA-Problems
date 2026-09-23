# Restore IP Addresses

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A  **valid IP address**  consists of exactly four integers separated by single dots. Each integer is between `0` and `255` (**inclusive**) and cannot have leading zeros.

- For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.

Given a string `s` containing only digits, return  *all possible valid IP addresses that can be formed by inserting dots into* `s`. You are  **not**  allowed to reorder or remove any digits in `s`. You may return the valid IP addresses in  **any**  order.

 

 **Example 1:** 

```
Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]

```

 **Example 2:** 

```
Input: s = "0000"
Output: ["0.0.0.0"]

```

 **Example 3:** 

```
Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]

```

 

 **Constraints:** 

- 1 <= s.length <= 20
- s consists of digits only.

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 50.06%)  
**Memory:** 44.4 MB (beats 46.76%)  
**Submitted:** 2026-09-23T16:40:38.529Z  

```java
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> parts = new ArrayList<>();

        restore(s, 0, s.length(), res, parts);

        return res;
    }

    private static void restore(String s, int idx, int n, List<String> res, List<String> parts)
    {
        if(parts.size() == 4) 
        {
            if(idx == n)
            {
                String validIpAddress = "";
                for(int i=0; i<4; i++)
                {
                    validIpAddress += parts.get(i);
                    if(i != 3) validIpAddress += ".";
                }

                res.add(validIpAddress);
            }
            
            return;
        }

        for(int len=1; len<=3; len++)
        {
            if(idx + len > n) break;

            String part = s.substring(idx, idx+len);

            if(part.length() > 1 && part.charAt(0) == '0')
                continue;

            if(Integer.parseInt(part) > 255)
                continue;

            parts.add(part);

            restore(s, idx+len, n, res, parts);

            parts.remove(parts.size() - 1);
        }

    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/restore-ip-addresses/)