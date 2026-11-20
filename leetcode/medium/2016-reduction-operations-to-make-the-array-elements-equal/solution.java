class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int count = 0;

        for(int i=1; i<n; i++) {
            if(nums[i] != nums[i-1]) {
                count += n - i;
            }
        }

        return count;
    }
}