class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length, res = 0;
        int total_even_sum = 0, total_odd_sum = 0;

        for(int i=0; i<n; i++)
        {
            if((i & 1) == 0) total_even_sum += nums[i];
            else total_odd_sum += nums[i];
        }

        int even_sum = 0, odd_sum = 0;

        for(int i=0; i<n; i++)
        {
            if((i & 1) == 0)
            {
                int new_even_sum = total_odd_sum - odd_sum;
                int new_odd_sum = total_even_sum - (even_sum + nums[i]);

                if(even_sum + new_even_sum == odd_sum + new_odd_sum) 
                    res++;

                even_sum += nums[i];
            } 
            else
            {
                int new_even_sum = total_odd_sum - (odd_sum + nums[i]);
                int new_odd_sum = total_even_sum - even_sum;

                if(even_sum + new_even_sum == odd_sum + new_odd_sum)
                    res++;

                odd_sum += nums[i];
            }
        }

        return res;
    }
}