class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        for(int i=0; i<servers.length; i++) {
            free.offer(new int[] {servers[i], i});
        }

        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if(a[0] != b[0]) return Long.compare(a[0], b[0]);
            if(a[1] != b[1]) return Long.compare(a[1], b[1]);
            return Long.compare(a[2], b[2]);            
        });
        
        int m = tasks.length;
        int[] res = new int[m];

        for(int i=0; i<m; i++)
        {
            while(!busy.isEmpty() && busy.peek()[0] <= i) {
                long[] curr = busy.poll();
                free.offer(new int[] {(int) curr[1], (int) curr[2]});
            }

            if(!free.isEmpty()) {
                int[] curr = free.poll();
                res[i] = curr[1];
                busy.offer(new long[] {i + (long) tasks[i], curr[0], curr[1]});
            } else {
                long[] curr = busy.poll();
                res[i] = (int) curr[2];
                busy.offer(new long[] {curr[0] + tasks[i], curr[1], curr[2]});
            }
        }

        return res;
    }
}