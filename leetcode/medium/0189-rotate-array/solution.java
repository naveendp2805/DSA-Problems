class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length, x = 0;
        int[] res = new int[n];

        k %= n;

        for(int i=n-k; i<n; i++) {
            res[x++] = nums[i];
        }

        for(int i=0; i<n-k; i++) {
            res[x++] = nums[i];
        }

        for(int i=0; i<n; i++) {
            nums[i] = res[i];
        }
    }
}