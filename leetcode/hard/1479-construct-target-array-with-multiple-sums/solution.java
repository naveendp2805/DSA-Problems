class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;

        for(int num : target) {
            pq.offer((long) num);
            sum += num;
        }

        while(true) {
            long max = pq.poll();
            long rem = sum - max;

            if(max == 1 || rem == 1) {
                return true;
            }

            if(rem == 0 || max <= rem) {
                return false;
            }

            long prev = max % rem;

            if(prev == 0) {
                return false;
            }

            sum = rem + prev;

            pq.offer(prev);
        }
    }
}