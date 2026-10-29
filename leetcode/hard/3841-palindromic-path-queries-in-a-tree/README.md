# Palindromic Path Queries in a Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an undirected tree with `n` nodes labeled 0 to `n - 1`. This is represented by a 2D array `edges` of length `n - 1`, where `edges[i] = [ui, vi]` indicates an undirected edge between nodes `ui` and `vi`.

You are also given a string `s` of length `n` consisting of lowercase English letters, where `s[i]` represents the character assigned to node `i`.

You are also given a string array `queries`, where each `queries[i]` is either:

- "update ui c": Change the character at node ui to c. Formally, update s[ui] = c.
- "query ui vi": Determine whether the string formed by the characters on the unique path from ui to vi (inclusive) can be rearranged into a palindrome.

Return a boolean array `answer`, where `answer[j]` is `true` if the `jth` query of type `"query ui vi"​​​​​​​` can be rearranged into a  **palindrome**, and `false` otherwise.

 

 **Example 1:** 

 **Input:**  n = 3, edges = [[0,1],[1,2]], s = "aac", queries = ["query 0 2","update 1 b","query 0 2"]

 **Output:**  [true,false]

 **Explanation:** 

- "query 0 2": Path 0 → 1 → 2 gives "aac", which can be rearranged to form "aca", a palindrome. Thus, answer[0] = true.
- "update 1 b": Update node 1 to 'b', now s = "abc".
- "query 0 2": Path characters are "abc", which cannot be rearranged to form a palindrome. Thus, answer[1] = false.

Thus, `answer = [true, false]`.

 **Example 2:** 

 **Input:**  n = 4, edges = [[0,1],[0,2],[0,3]], s = "abca", queries = ["query 1 2","update 0 b","query 2 3","update 3 a","query 1 3"]

 **Output:**  [false,false,true]

 **Explanation:** 

- "query 1 2": Path 1 → 0 → 2 gives "bac", which cannot be rearranged to form a palindrome. Thus, answer[0] = false.
- "update 0 b": Update node 0 to 'b', now s = "bbca".
- "query 2 3": Path 2 → 0 → 3 gives "cba", which cannot be rearranged to form a palindrome. Thus, answer[1] = false.
- "update 3 a": Update node 3 to 'a', s = "bbca".
- "query 1 3": Path 1 → 0 → 3 gives "bba", which can be rearranged to form "bab", a palindrome. Thus, answer[2] = true.

Thus, `answer = [false, false, true]`.

 

 **Constraints:** 

- 1 <= n == s.length <= 5 * 104
- edges.length == n - 1
- edges[i] = [ui, vi]
- 0 <= ui, vi <= n - 1
- s consists of lowercase English letters.
- The input is generated such that edges represents a valid tree.
- 1 <= queries.length <= 5 * 104​​​​​​​queries[i] = "update ui c" or queries[i] = "query ui vi" 0 <= ui, vi <= n - 1 c is a lowercase English letter.

## Solution

**Language:** Java  
**Runtime:** 125 ms (beats 100.00%)  
**Memory:** 215.1 MB (beats 57.14%)  
**Submitted:** 2026-10-29T05:37:50.987Z  

```java
class Solution {
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        final int LOG = 16;
        int[][] up = new int[LOG][n];
        for (int[] row : up) Arrays.fill(row, -1);
        int[] depth = new int[n], in = new int[n], out = new int[n], parent = new int[n];
        Arrays.fill(parent, -1);
        int[] mask = new int[n];
        for (int i = 0; i < n; i++) mask[i] = 1 << (s.charAt(i) - 'a');
        int[] timer = {1};
        dfs(0, -1, g, up, depth, in, out, parent, timer, LOG);
        int[] bit = new int[n + 2];
        for (int i = 0; i < n; i++) rangeXor(in[i], out[i] - 1, mask[i], bit, n);
        List<Boolean> ans = new ArrayList<>();
        for (String q : queries) {
            if (q.charAt(0) == 'u') {
                int u = 0, i = 7;
                while (q.charAt(i) != ' ') u = u * 10 + (q.charAt(i++) - '0');
                char c = q.charAt(q.length() - 1);
                int nm = 1 << (c - 'a');
                int delta = mask[u] ^ nm;
                mask[u] = nm;
                rangeXor(in[u], out[u] - 1, delta, bit, n);
            } else {
                int u = 0, v = 0, i = 6;
                while (q.charAt(i) != ' ') u = u * 10 + (q.charAt(i++) - '0');
                i++;
                while (i < q.length()) v = v * 10 + (q.charAt(i++) - '0');
                int m = pathXor(u, v, in, mask, up, depth, parent, bit, LOG);
                ans.add(Integer.bitCount(m) <= 1);
            }
        }
        return ans;
    }
    void dfs(int u, int p, List<Integer>[] g, int[][] up, int[] depth, int[] in, int[] out, int[] parent, int[] timer, int LOG) {
        in[u] = timer[0]++;
        parent[u] = p;
        up[0][u] = p;
        for (int k = 1; k < LOG; k++) {
            if (up[k - 1][u] != -1) up[k][u] = up[k - 1][up[k - 1][u]];
        }
        for (int v : g[u]) if (v != p) {
            depth[v] = depth[u] + 1;
            dfs(v, u, g, up, depth, in, out, parent, timer, LOG);
        }
        out[u] = timer[0];
    }
    void upd(int i, int val, int[] bit, int n) {
        for (; i <= n; i += i & -i) bit[i] ^= val;
    }
    int qry(int i, int[] bit) {
        int res = 0;
        for (; i > 0; i -= i & -i) res ^= bit[i];
        return res;
    }
    void rangeXor(int l, int r, int val, int[] bit, int n) {
        if (l > r) return;
        upd(l, val, bit, n);
        upd(r + 1, val, bit, n);
    }
    int getLca(int u, int v, int[][] up, int[] depth, int[] parent, int LOG) {
        if (depth[u] < depth[v]) {
            int t = u; u = v; v = t;
        }
        int diff = depth[u] - depth[v];
        for (int k = 0; k < LOG; k++) if (((diff >> k) & 1) == 1) u = up[k][u];
        if (u == v) return u;
        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }
        return parent[u];
    }
    int pathXor(int u, int v, int[] in, int[] mask, int[][] up, int[] depth, int[] parent, int[] bit, int LOG) {
        int l = getLca(u, v, up, depth, parent, LOG);
        return qry(in[u], bit) ^ qry(in[v], bit) ^ mask[l];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/palindromic-path-queries-in-a-tree/)