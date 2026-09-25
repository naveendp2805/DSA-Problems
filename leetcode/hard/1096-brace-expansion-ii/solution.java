class Solution {
    public List<String> braceExpansionII(String expression) {
        TreeSet<String> res = new TreeSet<>();
        dfs(expression, res);
        return new ArrayList<>(res);
    }

    private static void dfs(String s, TreeSet<String> res)
    {
        int r = s.indexOf("}");

        if(r == -1) {
            res.add(s);
            return;
        }

        int l = s.lastIndexOf("{", r);

        String left = s.substring(0, l);
        String right = s.substring(r+1);
        String inside = s.substring(l+1, r);

        for(String part : inside.split(","))
            dfs(left + part + right, res);
    }
}