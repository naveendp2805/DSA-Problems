class Solution {
    public int maxDepth(String s) {
        int res = 0, c = 0;

        for(char ch : s.toCharArray())
        {
            if(ch == '(') c++;
            else if(ch == ')') c--;

            res = Math.max(res, c);
        }

        return res;
    }
}