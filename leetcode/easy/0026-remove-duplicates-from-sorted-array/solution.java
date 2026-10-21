class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1, n = nums.length;

        for(int i=1; i<n; i++)
        {
            if(nums[i] != nums[k-1]) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }
}