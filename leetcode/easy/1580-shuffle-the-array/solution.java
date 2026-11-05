class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int i=0, j=n, x=0;

        while(i < n && j < 2 * n)
        {
            res[x++] = nums[i++];
            res[x++] = nums[j++];
        }

        return res;
    }
}