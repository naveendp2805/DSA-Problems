class Solution {
    public long countCommas(long n) {
        long res = 0, start = 1000;

        while(start <= n)
        {
            res += (n - start + 1L);

            start *= 1000;
        }

        return res;
    }
}