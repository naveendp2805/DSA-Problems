# X of a Kind in a Deck of Cards

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given an integer array `deck` where `deck[i]` represents the number written on the `ith` card.

Partition the cards into  **one or more groups**  such that:

- Each group has exactly x cards where x > 1, and
- All the cards in one group have the same integer written on them.

Return `true` *if such partition is possible, or* `false` *otherwise*.

 

 **Example 1:** 

```
Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].

```

 **Example 2:** 

```
Input: deck = [1,1,1,2,2,2,3,3]
Output: false
Explanation: No possible partition.

```

 

 **Constraints:** 

- 1 <= deck.length <= 104
- 0 <= deck[i] < 104

## Solution

**Language:** Java  
**Runtime:** 11 ms (beats 67.03%)  
**Memory:** 47.3 MB (beats 57.77%)  
**Submitted:** 2026-08-28T15:55:41.115Z  

```java
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : deck)
            map.put(x, map.getOrDefault(x, 0) + 1);

        int res = 0;
        for(int x : map.values())
            res = gcd(x, res);

        return res > 1;
    }

    private static int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/)