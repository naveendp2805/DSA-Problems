class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1, n = nums.length;

        for(int i=1; i<n; i++)
        {
            if(k < 2 || nums[i] != nums[k-2])
                nums[k++] = nums[i];
        }

        return k;
    }
}