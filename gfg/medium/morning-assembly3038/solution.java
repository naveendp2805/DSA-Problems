class Solution {
    public int minMoves(int[] arr) {
        // code here
        int n = arr.length, res = 0;
        int[] dp = new int[n + 1];
        
        for(int i=0; i<n; i++)
        {
            int num = arr[i];
            
            dp[num] = dp[num - 1] + 1;
            res = Math.max(res, dp[num]);
        }
        
        return n - res;
    }
}