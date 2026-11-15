class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        int even = 1, odd = 0;
        int parity = 0, res = 0;

        for(int num : arr) {
            parity = (parity + num) % 2;

            if(parity == 1) {
                res = (res + even) % MOD;
                odd++;
            } else {
                res = (res + odd) % MOD;
                even++;
            }
        }

        return res;
    }
}