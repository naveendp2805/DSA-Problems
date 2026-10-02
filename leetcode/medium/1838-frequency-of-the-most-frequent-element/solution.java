class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        long res = 0, sum = 0;
        int i = 0;

        for(int j=0; j<nums.length; j++)
        {
            sum += nums[j];

            while(nums[j] * (j - i + 1L) > (sum + k)) {
                sum -= nums[i++];
            }

            res = Math.max(res, j-i+1L);
        }
        return (int) res;
    }
}