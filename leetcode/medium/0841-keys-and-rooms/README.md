# Keys and Rooms

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

There are `n` rooms labeled from `0` to `n - 1` and all the rooms are locked except for room `0`. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of  **distinct keys**  in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.

Given an array `rooms` where `rooms[i]` is the set of keys that you can obtain if you visited room `i`, return `true`  *if you can visit  **all**  the rooms, or*  `false`  *otherwise*.

 

 **Example 1:** 

```
Input: rooms = [[1],[2],[3],[]]
Output: true
Explanation: 
We visit room 0 and pick up key 1.
We then visit room 1 and pick up key 2.
We then visit room 2 and pick up key 3.
We then visit room 3.
Since we were able to visit every room, we return true.

```

 **Example 2:** 

```
Input: rooms = [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.

```

 

 **Constraints:** 

- n == rooms.length
- 2 <= n <= 1000
- 0 <= rooms[i].length <= 1000
- 1 <= sum(rooms[i].length) <= 3000
- 0 <= rooms[i][j] < n
- All the values of rooms[i] are unique.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 50.83%)  
**Memory:** 46.3 MB (beats 45.20%)  
**Submitted:** 2026-10-05T07:15:54.394Z  

```java
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int c = 0, n = rooms.size();
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++)
        {
            if(!visited[i])
            {
                bfs(rooms, i, visited);
                c++;

                if(c > 1)
                    return false;
            }
        }

        return true;
    }

    private void bfs(List<List<Integer>> rooms, int s, boolean[] visited)
    {
        Queue<Integer> q = new LinkedList<>();

        q.offer(s);
        visited[s] = true;

        while(!q.isEmpty())
        {
            int room = q.poll();

            for(int x : rooms.get(room))
            {
                if(!visited[x])
                {
                    q.offer(x);
                    visited[x] = true;
                }
            }
        }
        
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/keys-and-rooms/)