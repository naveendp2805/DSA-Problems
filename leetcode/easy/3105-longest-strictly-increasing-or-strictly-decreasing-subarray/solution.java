class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int res = 1, up = 1, down = 1;

        for(int i=1; i<nums.length; i++)
        {
            up = nums[i-1] < nums[i] ? up + 1 : 1;
            down = nums[i-1] > nums[i] ? down + 1 : 1;

            res = Math.max(res, Math.max(up, down));
        }

        return res;
    }
}