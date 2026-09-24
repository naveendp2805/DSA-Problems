class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        int[] res = new int[n];

        left[0] = 1;
        for(int i=0; i<n-1; i++)
            left[i+1] = left[i] * nums[i];

        res[n-1] = 1;
        for(int i=n-1; i>0; i--)
            res[i-1] = res[i] * nums[i];

        for(int i=0; i<n; i++)
            res[i] *= left[i];

        return res;
    }
}