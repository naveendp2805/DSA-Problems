class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        List<Integer> res = new ArrayList<>();

        int x = 0, y = 0;
        int dx = 1, dy = 0;

        for(int i=0; i<m*n; i++)
        {
            res.add(matrix[y][x]);
            matrix[y][x] = -101;

            int new_x = x + dx; 
            int new_y = y + dy;

            if(!(new_x >= 0 && new_x < n && new_y >= 0 && new_y < m) || matrix[new_y][new_x] == -101)
            {
                int temp = dx;
                dx = -dy;
                dy = temp;       
            }

            x += dx;
            y += dy;
        }

        return res;
    }
}