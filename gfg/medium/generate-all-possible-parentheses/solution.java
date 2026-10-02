class Solution {
    public ArrayList<String> generateParentheses(int n) {
        // code here
        ArrayList<String> res = new ArrayList<>();

        generateParenthesis(n/2, n/2, res, "");

        return res;
    }

    private void generateParenthesis(int open, int close, ArrayList<String> res, String comb)
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