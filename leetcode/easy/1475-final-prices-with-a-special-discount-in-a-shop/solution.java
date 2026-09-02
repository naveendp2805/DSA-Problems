class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length, res[] = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i=1; i<n; i++)
        {
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i])
            {
                int idx = stack.pop();
                res[idx] = prices[idx] - prices[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty())
        {
            int idx = stack.pop();
            res[idx] = prices[idx];
        }

        return res;
    }
}