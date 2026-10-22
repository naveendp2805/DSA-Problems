class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        boolean fault = false;

        for(int i=0; i<n; i++)
        {
            if(nums[i] > nums[(i+1) % n])
            {
                if(fault)
                    return false;
                
                fault = true;
            }
        }

        return true;
    }
}