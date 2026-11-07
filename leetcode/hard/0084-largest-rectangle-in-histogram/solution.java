class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int res = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<=n; i++)
        {
            int currHeight = i == n ? 0 : heights[i];

            while(!stack.isEmpty() && heights[stack.peek()] > currHeight)
            {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                int area = width * height;

                res = Math.max(res, area);
            }

            stack.push(i);
        }

        return res;
    }
}