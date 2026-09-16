class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        for(int i=0; i<m; i++)
        {
            for(int j=i+1; j<n; j++)
            {                
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0; i<m; i++)
            reverseArray(matrix[i]);
    }

    private static void reverseArray(int[] arr)
    {
        int i = 0, j = arr.length - 1;

        while(i < j)
        {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}