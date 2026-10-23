class Solution {
    public int sortPermutation(int[] nums) {
        int res = -1, n = nums.length;

        for(int i=0; i<n; i++) {
            if(i != nums[i])
                res &= nums[i];
        }

        return res == -1 ? 0 : res;
    }
}