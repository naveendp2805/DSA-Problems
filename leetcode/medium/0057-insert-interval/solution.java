class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length + 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int[] interval : intervals) {
            pq.add(interval);
        }

        pq.add(newInterval);

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