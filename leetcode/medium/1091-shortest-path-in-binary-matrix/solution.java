class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)
            return -1;

        int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},         {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        grid[0][0] = 1;

        int length = 1;

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i=0; i<size; i++)
            {
                int[] ele = q.poll();
                int r = ele[0], c = ele[1];

                if(r == n-1 && c == n-1)
                    return length;

                for(int[] dir : dirs)
                {
                    int rn = r + dir[0], cn = c + dir[1];

                    if(rn >= 0 && rn < n && cn >= 0 && cn < n && grid[rn][cn] == 0)
                    {
                        grid[rn][cn] = 1;
                        q.offer(new int[]{rn, cn});
                    }
                }
            }

            length++;
        }

        return -1;
    }
}