# Count Palindromic Strings with Constraints

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two integers  **n**   and  **k**, consider an alphabet consisting of the first k lowercase English letters. Find the number of palindromic strings whose length is less than or equal to n, such that:

- Every character in the string belongs to the given alphabet.
- No character appears more than twice in the string.

 **Note:** Since the answer can be very large, return it modulo  **10^9+7**.

 **Examples:** 

```
Input: n = 3, k = 2
Output: 6
Explanation: The possible strings are: "a", "b", "aa", "bb", "aba", "bab".
```

```
Input: n = 4, k = 3
Output: 18
Explanation: The possible strings are:"a", "b", "c", "aa", "bb", "cc", "aba", "aca", "bab", "bcb", "cac", "cbc", "abba", "acca", "baab", "bccb", "caac", "cbbc". 
```

 **Constraints:** 
1 ≤ k ≤ 26
1 ≤ n ≤ 52
n ≤ 2*k

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-01T15:09:38.992Z  

```java
class Solution {
    int MOD = 1_000_000_007;
    public int palindromicStrings(int n, int k) {
        // code here
        long ans = 0, fact = k;
        for (int i = 0; i < n / 2; i++) {
            ans = (ans + fact) % MOD;
            fact = (fact * (k - i - 1)) % MOD;
        }
        if (n % 2 == 1) return (int) ((2 * ans + fact) % MOD);
        return (int) ((2 * ans) % MOD);
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/number-of-palindromic-strings2706/1)