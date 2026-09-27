class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();

        StringBuilder res = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int[] link = new int[n];

        for(int i=0; i<n; i++)
        {
            char ch = s.charAt(i);

            if(ch == '(')
                stack.push(i);
            else if(ch == ')')
            {
                link[i] = stack.pop();
                link[link[i]] = i;
            }
        }

        int i = 0, dir = 1;

        while(i < n)
        {
            char ch = s.charAt(i);

            if(Character.isLetter(ch))
                res.append(ch);
            else
            {
                dir = -dir;
                i = link[i];
            }

            i += dir;
        }

        return res.toString();
    }
}