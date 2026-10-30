class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int[] interval : intervals) {
            pq.offer(interval);
        }

        int[] prev = pq.poll();
        List<int[]> res = new ArrayList<>();

        while(!pq.isEmpty())
        {
            int[] curr = pq.poll();

            if(curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                res.add(prev);
                prev = curr;
            }
        }

        res.add(prev);

        return res.toArray(new int[res.size()][]);
    }
}