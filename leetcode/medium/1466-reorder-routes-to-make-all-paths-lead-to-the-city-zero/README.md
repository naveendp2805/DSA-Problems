# Reorder Routes to Make All Paths Lead to the City Zero

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

There are `n` cities numbered from `0` to `n - 1` and `n - 1` roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by `connections` where `connections[i] = [ai, bi]` represents a road from city `ai` to city `bi`.

This year, there will be a big event in the capital (city `0`), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city `0`. Return the  **minimum**  number of edges changed.

It's  **guaranteed**  that each city can reach city `0` after reorder.

 

 **Example 1:** 

```
Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

```

 **Example 2:** 

```
Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

```

 **Example 3:** 

```
Input: n = 3, connections = [[1,0],[2,0]]
Output: 0

```

 

 **Constraints:** 

- 2 <= n <= 5 * 104
- connections.length == n - 1
- connections[i].length == 2
- 0 <= ai, bi <= n - 1
- ai != bi

## Solution

**Language:** Java  
**Runtime:** 29 ms (beats 95.31%)  
**Memory:** 115 MB (beats 61.07%)  
**Submitted:** 2026-10-05T09:22:56.588Z  

```java
class Solution {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++)
            graph[i] = new ArrayList<>();

        for(int[] edge : connections)
        {
            int a = edge[0], b = edge[1];

            graph[a].add(new int[]{b, 1});
            graph[b].add(new int[]{a, 0});
        }

        return dfs(0, graph, new boolean[n]);
    }

    private int dfs(int s, List<int[]>[] graph, boolean[] visited)
    {
        visited[s] = true;

        int res = 0;

        for(int[] edge : graph[s])
        {
            int next = edge[0];
            int cost = edge[1];

            if(!visited[next])
            {
                res += cost;
                res += dfs(next, graph, visited);
            }
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/)