class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long res = 0;
        int n = costs.length;

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        int i = 0, j = n-1;

        while(k-- > 0)
        {
            while(pq1.size() < candidates && i <= j) {
                pq1.offer(costs[i++]);
            }

            while(pq2.size() < candidates && i <= j) {
                pq2.offer(costs[j--]);
            }

            int top1 = pq1.isEmpty() ? Integer.MAX_VALUE : pq1.peek();
            int top2 = pq2.isEmpty() ? Integer.MAX_VALUE : pq2.peek();

            res += top1 <= top2 ? pq1.poll() : pq2.poll();
        }

        return res;
    }
}