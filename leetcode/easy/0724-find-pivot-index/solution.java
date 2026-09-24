class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int lsum = 0, rsum = 0;

        for(int num : nums)
            rsum += num;

        for(int i=0; i<n; i++)
        {
            if(lsum == rsum - lsum - nums[i])
                return i;

            lsum += nums[i];
        }

        return -1;
    }
}