class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int freshOranges = 0;

        Queue<int[]> q = new LinkedList<>();

        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 2)
                    q.offer(new int[]{i, j});
                else if(grid[i][j] == 1)
                    freshOranges++;
            }
        }

        if(freshOranges == 0)
            return 0;

        if(q.isEmpty())
            return -1;

        int x, y;
        int mins = -1;

        while(!q.isEmpty())
        {
            int size = q.size();

            while(size-- > 0)
            {
                int[] curr = q.poll();

                for(int[] dir : dirs)
                {
                    x = curr[0] + dir[0];
                    y = curr[1] + dir[1];

                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1)
                    {
                        grid[x][y] = 2;
                        freshOranges--;
                        q.offer(new int[]{x, y});
                    }
                }
            }

            mins++;
        }

        return freshOranges == 0 ? mins : -1;
    }
}