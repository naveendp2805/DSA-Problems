class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0, res = 0;

        for(int gn : gain)
        {
            sum += gn;
            res = Math.max(res, sum);
        }

        return res;
    }
}