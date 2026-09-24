class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int i = 0, res = 0, zeroes = 0;

        for(int j=0; j<n; j++)
        {
            if(nums[j] == 0)
                zeroes++;

            while(zeroes > 1)
            {
                if(nums[i] == 0)
                    zeroes--;
                i++;
            }

            res = Math.max(res, j - i);
        }

        return res;
    }
}