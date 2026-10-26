class Solution {
    int[][] grid;
    int m, n;

    public int countIslands(int[][] grid, int k) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        int res = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] != 0) {
                    long sum = closed(i, j);

                    if(sum % k == 0) res++;
                }
            }
        }

        return res;
    }

    private long closed(int i, int j) {
        if(i < 0 || i == m || j < 0 || j == n)
            return 0;

        if(grid[i][j] == 0)
            return 0;

        long sum = grid[i][j];
        grid[i][j] = 0;

        return sum + closed(i+1, j) + closed(i-1, j) + closed(i, j+1) + closed(i, j-1);
    }
}