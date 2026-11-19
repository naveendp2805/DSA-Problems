class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int twoSmallest = nums[n-1] - nums[2];
        int twoLargest = nums[n-3] - nums[0];
        int oneSmallestAndOneLargest = nums[n-2] - nums[1];

        return Math.min(oneSmallestAndOneLargest, Math.min(twoSmallest, twoLargest));
    }
}