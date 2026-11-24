class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int res = 1;

        for(int i=0; i<n; i++) {
            long p = nums[i], g = nums[i], l = nums[i];

            for(int j=i+1; j<n; j++) {
                p *= nums[j];
                g = gcd(g, nums[j]);
                l = l * nums[j] / gcd(l, nums[j]);

                if(p > g * l) break;

                if(p == g * l) res = Math.max(res, j - i + 1);
            }
        }

        return res;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}