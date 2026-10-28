class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int maxXor = 1024;

        boolean[][] dp = new boolean[m * n][maxXor];
        dp[0][grid[0][0]] = true;

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i == 0 && j == 0)
                    continue;

                int curr = i * n + j;
                int val = grid[i][j];

                for(int x=0; x<maxXor; x++)
                {
                    if(i>0 && dp[(i-1) * n + j][x])
                        dp[curr][x ^ val] = true;

                    if(j>0 && dp[i * n + j - 1][x])
                        dp[curr][x ^ val] = true;
                }
            }
        }

        int dest = m * n - 1;

        for(int x=0; x<maxXor; x++) {
            if(dp[dest][x])
                return x;
        }

        return -1;
    }
}