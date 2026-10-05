class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int c = 0, n = rooms.size();
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++)
        {
            if(!visited[i])
            {
                bfs(rooms, i, visited);
                c++;

                if(c > 1)
                    return false;
            }
        }

        return true;
    }

    private void bfs(List<List<Integer>> rooms, int s, boolean[] visited)
    {
        Queue<Integer> q = new LinkedList<>();

        q.offer(s);
        visited[s] = true;

        while(!q.isEmpty())
        {
            int room = q.poll();

            for(int x : rooms.get(room))
            {
                if(!visited[x])
                {
                    q.offer(x);
                    visited[x] = true;
                }
            }
        }
        
    }
}