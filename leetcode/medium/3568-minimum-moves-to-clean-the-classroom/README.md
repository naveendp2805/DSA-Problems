# Minimum Moves to Clean the Classroom

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an `m x n` grid `classroom` where a student volunteer is tasked with cleaning up litter scattered around the room. Each cell in the grid is one of the following:

- 'S': Starting position of the student
- 'L': Litter that must be collected (once collected, the cell becomes empty)
- 'R': Reset area that restores the student's energy to full capacity, regardless of their current energy level (can be used multiple times)
- 'X': Obstacle the student cannot pass through
- '.': Empty space

You are also given an integer `energy`, representing the student's maximum energy capacity. The student starts with this energy from the starting position `'S'`.

Each move to an adjacent cell (up, down, left, or right) costs 1 unit of energy. If the energy reaches 0, the student can only continue if they are on a reset area `'R'`, which resets the energy to its  **maximum**  capacity `energy`.

Return the  **minimum**  number of moves required to collect all litter items, or `-1` if it's impossible.

 

 **Example 1:** 

 **Input:**  classroom = ["S.", "XL"], energy = 2

 **Output:**  2

 **Explanation:** 

- The student starts at cell (0, 0) with 2 units of energy.
- Since cell (1, 0) contains an obstacle 'X', the student cannot move directly downward.
- A valid sequence of moves to collect all litter is as follows: Move 1: From (0, 0) → (0, 1) with 1 unit of energy and 1 unit remaining. Move 2: From (0, 1) → (1, 1) to collect the litter 'L'.
- The student collects all the litter using 2 moves. Thus, the output is 2.

 **Example 2:** 

 **Input:**  classroom = ["LS", "RL"], energy = 4

 **Output:**  3

 **Explanation:** 

- The student starts at cell (0, 1) with 4 units of energy.
- A valid sequence of moves to collect all litter is as follows: Move 1: From (0, 1) → (0, 0) to collect the first litter 'L' with 1 unit of energy used and 3 units remaining. Move 2: From (0, 0) → (1, 0) to 'R' to reset and restore energy back to 4. Move 3: From (1, 0) → (1, 1) to collect the second litter 'L'.
- The student collects all the litter using 3 moves. Thus, the output is 3.

 **Example 3:** 

 **Input:**  classroom = ["L.S", "RXL"], energy = 3

 **Output:**  -1

 **Explanation:** 

No valid path collects all `'L'`.

 

 **Constraints:** 

- 1 <= m == classroom.length <= 20
- 1 <= n == classroom[i].length <= 20
- classroom[i][j] is one of 'S', 'L', 'R', 'X', or '.'
- 1 <= energy <= 50
- There is exactly one 'S' in the grid.
- There are at most 10 'L' cells in the grid.

## Solution

**Language:** Java  
**Runtime:** 111 ms (beats 95.24%)  
**Memory:** 60.9 MB (beats 76.19%)  
**Submitted:** 2026-09-01T14:51:12.626Z  

```java
class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();

        int[][] id = new int[m][n];
        for(int r=0; r<m; r++)
            Arrays.fill(id[r], -1);

        int k=0, sr=0, sc=0;

        for(int r=0; r<m; r++)
        {
            for(int c=0; c<n; c++)
            {
                if(classroom[r].charAt(c) == 'S')
                {
                    sr = r;
                    sc = c;
                } else if(classroom[r].charAt(c) == 'L')
                    id[r][c] = k++;
            }
        }

        if(k == 0) return 0;

        int totalMask = (1 << k) - 1;

        int[][][] best = new int[m][n][1 << k];
        for(int r=0; r<m; r++)
            for(int c=0; c<n; c++)
                Arrays.fill(best[r][c], -1);

        class State
        {
            int r, c, mask, e, moves;

            public State(int r, int c, int mask, int e, int moves) {
                this.r = r;
                this.c = c;
                this.mask = mask;
                this.e = e;
                this.moves = moves;
            }
        }

        Queue<State> q = new LinkedList<>();

        best[sr][sc][0] = energy;
        q.offer(new State(sr, sc, 0, energy, 0));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!q.isEmpty())
        {
            State curr = q.poll();

            for(int d=0; d<4; d++)
            {
                int nr = curr.r + dr[d], nc = curr.c + dc[d];

                if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                char ch = classroom[nr].charAt(nc);

                if(ch == 'X') continue;

                int ne = curr.e - 1, nmask = curr.mask;

                if(ne < 0) continue;

                if(ch == 'R') ne = energy;

                if(ch == 'L') nmask |= (1 << id[nr][nc]);

                if(nmask == totalMask) return curr.moves + 1;

                if(ne <= best[nr][nc][nmask]) continue;

                best[nr][nc][nmask] = ne;

                q.offer(new State(nr, nc, nmask, ne, curr.moves + 1));
            }
        }

        return -1;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-moves-to-clean-the-classroom/)