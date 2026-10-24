class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, res = Integer.MAX_VALUE;
        int i = 0, sum = 0;

        for(int j=0; j<n; j++)
        {
            sum += nums[j];

            while(sum >= target) {
                res = Math.min(res, j - i + 1);
                sum -= nums[i++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}