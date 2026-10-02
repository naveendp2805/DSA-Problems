class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        generateParenthesis(n, n, res, "");

        return res;
    }

    private void generateParenthesis(int open, int close, List<String> res, String comb)
    {
        if(open == 0 && close == 0) {
            res.add(comb);
            return;
        }

        if(open > 0) {
            generateParenthesis(open - 1, close, res, comb + "(");
        }

        if(close > open) {
            generateParenthesis(open, close - 1, res, comb + ")");
        }
    }
}