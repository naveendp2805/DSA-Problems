class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        List<int[]> img1_1s = new ArrayList<>();
        List<int[]> img2_1s = new ArrayList<>();

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(img1[i][j] == 1) img1_1s.add(new int[]{i, j});
                if(img2[i][j] == 1) img2_1s.add(new int[]{i, j});
            }
        }

        int res = 0;
        int[][] pairsCount = new int[2*n][2*n];

        for(int[] l : img1_1s)
        {
            for(int[] r : img2_1s)
            {
                int dx = r[0] - l[0] + n;
                int dy = r[1] - l[1] + n;

                res = Math.max(res, ++pairsCount[dx][dy]);
            }
        }

        return res;
    }
}