class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], sum = nums[0];
        int n = nums.length;
        
        for(int i=1; i<n; i++)
        {
            sum = Math.max(nums[i], sum + nums[i]);

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}