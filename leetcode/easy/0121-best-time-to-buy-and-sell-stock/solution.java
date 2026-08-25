class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = -1, maxProfit = -1;

        for(int i=n-1; i>=0; i--)
        {
            max = Math.max(max, prices[i]);
            maxProfit = Math.max(maxProfit, max - prices[i]);
        }

        return maxProfit;
    }
}