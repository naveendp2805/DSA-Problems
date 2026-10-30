class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        List<Integer> res = new ArrayList<>();

        int x = 0, y = 0;
        int dx = 0, dy = 1;

        for(int i=0; i<m*n; i++)
        {
            res.add(matrix[x][y]);

            matrix[x][y] = -101;

            int new_x = x + dx;
            int new_y = y + dy;

            if(!(new_x >= 0 && new_x < m && new_y >= 0 && new_y < n) || matrix[new_x][new_y] == -101) {
                int temp = dy;
                dy = -dx;
                dx = temp;
            }

            x += dx;
            y += dy;
        }

        return res;
    }
}