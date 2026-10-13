class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long res = 0;

        long[] squares = new long[n];

        for(int i=0; i<n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(squares);

        int k = n / 2, i=0;

        for( ; i<k; i++) {
            res -= squares[i];
        }

        for( ; i<n; i++) {
            res += squares[i];
        }
        
        return res;
    }
}