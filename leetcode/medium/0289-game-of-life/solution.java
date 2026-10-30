class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        int[][] next = new int[m][n];

        int[][] dirs = {{-1, -1}, {-1, 0},  {-1, 1},
                        {0, -1},            {0, 1},
                        {1, -1},  {1, 0},   {1, 1}};

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                int ones = 0;
                for(int[] dir : dirs)
                {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if(x < 0 || x >= m || y < 0 || y >= n)
                        continue;

                    if(board[x][y] == 1)
                        ones++;
                    
                }

                if(board[i][j] == 0) {
                    next[i][j] = ones == 3 ? 1 : 0;
                }
                else {
                    next[i][j] = (ones < 2 || ones > 3) ? 0 : 1;
                }
            }
        }

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                board[i][j] = next[i][j];
            }
        }
    }
}