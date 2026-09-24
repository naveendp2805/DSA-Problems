class Solution {
    public int longestOnes(int[] nums, int k) {
        int c = 0, res = 0;
        int n = nums.length;
        int i = 0;

        for(int j=0; j<n; j++)
        {
            if(nums[j] == 0)
                c++;

            while(c > k)
            {
                if(nums[i] == 0)
                    c--;
                i++;
            }

            res = Math.max(res, j-i+1);
        }

        return res;
    }
}