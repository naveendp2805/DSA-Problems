class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        if(grid[0][0] == ')' || grid[m-1][n-1] == '(' || (m + n -1) % 2 == 1)
            return false;

        int maxBal = m + n - 1;

        boolean[][][] dp = new boolean[m][n][maxBal + 1];

        dp[0][0][1] = true;

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i == 0 && j == 0)
                    continue;

                int change = grid[i][j] == '(' ? 1 : -1;

                for(int bal=0; bal<=maxBal; bal++)
                {
                    int newBal = bal + change;

                    if(newBal < 0)
                        continue;

                    if(i > 0 && dp[i-1][j][bal])
                        dp[i][j][newBal] = true;

                    if(j > 0 && dp[i][j-1][bal])
                        dp[i][j][newBal] = true;
                }
            }
        }

        return dp[m-1][n-1][0];
    }
}