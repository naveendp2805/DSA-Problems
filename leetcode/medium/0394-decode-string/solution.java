class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<StringBuilder> strstack = new Stack<>();
        Stack<Integer> numstack = new Stack<>();
        int n = 0;

        for(char ch : s.toCharArray())
        {
            if(Character.isDigit(ch))
                n = n * 10 + (ch - '0');
            else if(ch == '[')
            {
                strstack.push(res);
                numstack.push(n);
                n = 0;
                res = new StringBuilder();
            }
            else if(ch == ']') 
            {
                int c = numstack.pop();
                StringBuilder str = strstack.pop();

                while(c-- > 0)
                    str.append(res);

                res = str;
            } 
            else
                res.append(ch);
        }

        return res.toString();
    }
}