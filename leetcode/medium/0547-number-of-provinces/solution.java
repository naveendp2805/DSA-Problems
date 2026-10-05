class Solution {
    public int findCircleNum(int[][] isConnected) {
        int c = 0, n = isConnected.length;

        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++)
        {
            if(!visited[i])
            {
                bfs(isConnected, i, visited);
                c++;
            }
        }

        return c;
    }

    private void bfs(int[][] isConnected, int s, boolean[] visited)
    {
        Queue<Integer> q = new LinkedList<>();

        q.offer(s);
        visited[s] = true;

        while(!q.isEmpty())
        {
            int i = q.poll();

            for(int x=0; x<isConnected[i].length; x++)
            {
                if(isConnected[i][x] == 1 && !visited[x])
                {
                    q.offer(x);
                    visited[x] = true;
                }
            }
        }
        
    }
}