class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0, n = tickets.length;

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++) {
            queue.offer(i);
        }

        while(tickets[k] > 0)
        {
            int idx = queue.poll();

            tickets[idx]--;
            res++;

            if(tickets[idx] > 0) {
                queue.offer(idx);
            }
        }

        return res;
    }
}