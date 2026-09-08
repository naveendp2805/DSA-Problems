class Solution {
    public int countCommas(int n) {
        int res = 0, start = 1000;

        while(start <= n)
        {
            res += (n - start + 1);
            start *= 1000;
        }

        return res;
    }

}