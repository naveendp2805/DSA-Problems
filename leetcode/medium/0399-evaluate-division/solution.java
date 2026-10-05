class Solution {

    class Edge
    {
        String node;
        double weight;

        Edge(String node, double weight)
        {
            this.node = node;
            this.weight = weight;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> graph = new HashMap<>();

        for(int i=0; i<equations.size(); i++)
        {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.get(a).add(new Edge(b, value));

            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(b).add(new Edge(a, 1.0 / value));
        }

        int n = queries.size();
        double[] res = new double[n];

        for(int i=0; i<n; i++)
        {
            String start = queries.get(i).get(0);
            String target = queries.get(i).get(1);

            if(!graph.containsKey(start) || !graph.containsKey(target))
            {
                res[i] = -1.0;
                continue;
            }

            Set<String> visited = new HashSet<>();

            res[i] = dfs(start, target, 1.0, graph, visited);
        }

        return res;
    }

    private double dfs(String curr, String target, double product, Map<String, List<Edge>> graph, Set<String> visited)
    {
        if(curr.equals(target))
            return product;

        visited.add(curr);

        for(Edge edge : graph.get(curr))
        {
            if(visited.contains(edge.node))
                continue;

            double res = dfs(edge.node, target, product * edge.weight, graph, visited);

            if(res != -1.0)
                return res;
        }

        return -1.0;
    }
}