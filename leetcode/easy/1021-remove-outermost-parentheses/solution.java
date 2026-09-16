class Solution {
    public String removeOuterParentheses(String s) {
        int c = 0;
        StringBuilder res = new StringBuilder();

        for(char ch : s.toCharArray())
        {
            if(ch == '(')
            {
                c++;
                if(c > 1) res.append(ch);
            }
            else if(ch == ')')
            {
                if(c > 1) res.append(ch);
                c--;
            }
        }

        return res.toString();
    }
}