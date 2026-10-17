class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        int[][] arr = new int[n][3];

        for(int i=0; i<n; i++)
        {
            int ele = nums[i];

            arr[i][0] = digitSum(ele);
            arr[i][1] = ele;
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] != b[0]
                                ? Integer.compare(a[0], b[0])
                                : Integer.compare(a[1], b[1])
                    );

        boolean[] visited = new boolean[n];
        int res = 0;

        for(int i=0; i<n; i++)
        {
            if(visited[i] || arr[i][2] == i)
                continue;

            int j = i, len = 0;

            while(!visited[j])
            {
                visited[j] = true;
                j = arr[j][2];
                len++;
            }

            res += len - 1;
        }

        return res;
    }

    private int digitSum(int n)
    {
        int res = 0;

        while(n > 0)
        {
            res += n % 10;
            n /= 10;
        }

        return res;
    }
}