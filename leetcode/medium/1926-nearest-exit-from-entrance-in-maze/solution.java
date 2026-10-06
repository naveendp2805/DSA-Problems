class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);

        maze[entrance[0]][entrance[1]] = '+';

        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int res = 0;
        int x, y;
        while(!q.isEmpty())
        {
            res++;

            int size = q.size();

            for(int i=0; i<size; i++)
            {
                int[] curr = q.poll();

                for(int[] dir : dirs)
                {
                    x = curr[0] + dir[0];
                    y = curr[1] + dir[1];

                    if(x < 0 || x == m || y < 0 || y == n || maze[x][y] == '+')
                        continue;

                    if(x == 0 || x == m-1 || y == 0 || y == n-1)
                        return res;

                    maze[x][y] = '+';
                    q.offer(new int[] {x, y});
                    
                }
            }
        }

        return -1;
    }
}