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