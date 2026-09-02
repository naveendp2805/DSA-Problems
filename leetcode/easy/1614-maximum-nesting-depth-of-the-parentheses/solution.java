class Solution {
    public int maxDepth(String s) {
        int c=0, res = 0;

        for(char ch : s.toCharArray())
        {
            if(ch == '(') c++;
            else if(ch == ')') res = Math.max(res, c--);
        }

        return res;
    }
}