class Solution {
    public int minInsertions(String s) {
        int n = s.length(), res = 0, open = 0;

        for(int i=0; i<n; i++)
        {
            if(s.charAt(i) == '(')
                open++;
            else
            {
                if(i+1 < n && s.charAt(i+1) == ')')
                    i++;
                else
                    res++;

                if(open > 0)
                    open--;
                else
                    res++;
            }
        }

        return open * 2 + res;
    }
}