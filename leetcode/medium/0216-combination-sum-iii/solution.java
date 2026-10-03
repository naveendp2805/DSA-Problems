class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        buildCombinationSum(1, 0, k, n, res, comb);

        return res;
    }

    private static void buildCombinationSum(int start, int sum, int k, int n, List<List<Integer>> res, List<Integer> comb)
    {
        if(comb.size() == k)
        {
            if(sum == n){
                res.add(new ArrayList<>(comb));
            }

            return;
        }

        for(int i=start; i<=9; i++)
        {
            comb.add(i);
            buildCombinationSum(i + 1, sum + i, k, n, res, comb);
            comb.remove(comb.size() - 1);
        }
    }
}