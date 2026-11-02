class Solution {
    public int calculate(String s) {
        int res = 0;
        int curr = 0, sign = 1;

        Stack<Integer> stack = new Stack<>();

        for(char ch : s.toCharArray())
        {
            if(Character.isDigit(ch)) {
                curr = curr * 10 + ch - '0';
            } else if(ch == '+') {
                res += curr * sign;
                sign = 1;
                curr = 0;
            } else if(ch == '-') {
                res += curr * sign;
                sign = -1;
                curr = 0;
            } else if(ch == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                curr = 0;
                sign = 1;
            } else if(ch == ')') {
                res += curr * sign;
                curr = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }

        res += curr * sign;

        return res;
    }
}