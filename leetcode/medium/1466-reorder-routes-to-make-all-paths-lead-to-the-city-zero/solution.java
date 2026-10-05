class Solution {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++)
            graph[i] = new ArrayList<>();

        for(int[] edge : connections)
        {
            int a = edge[0], b = edge[1];

            graph[a].add(new int[]{b, 1});
            graph[b].add(new int[]{a, 0});
        }

        return dfs(0, graph, new boolean[n]);
    }

    private int dfs(int s, List<int[]>[] graph, boolean[] visited)
    {
        visited[s] = true;

        int res = 0;

        for(int[] edge : graph[s])
        {
            int next = edge[0];
            int cost = edge[1];

            if(!visited[next])
            {
                res += cost;
                res += dfs(next, graph, visited);
            }
        }

        return res;
    }
}