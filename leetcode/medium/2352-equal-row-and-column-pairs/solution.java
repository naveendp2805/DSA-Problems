class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length, res = 0;

        Map<List<Integer>, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++)
        {
            List<Integer> row = new ArrayList<>();

            for(int j=0; j<n; j++)
                row.add(grid[i][j]);

            map.put(row, map.getOrDefault(row, 0) + 1);
        }

        for(int i=0; i<n; i++)
        {
            List<Integer> column = new ArrayList<>();

            for(int j=0; j<n; j++)
                column.add(grid[j][i]);

            res += map.getOrDefault(column, 0);
        }

        return res;
    }
}