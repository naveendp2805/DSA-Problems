class Solution {
    public int myAtoi(String s) {
        s = s.trim();

        if(s.isEmpty()) return 0;

        int res = 0, i=0, n =s.length();
        int sign = 1;

        if(s.charAt(i) == '-') {
            i++;
            sign = -1;
        } else if(s.charAt(i) == '+') {
            i++;
        }

        for(; i<n; i++)
        {
            char ch = s.charAt(i);

            if(!Character.isDigit(ch)) break;
            
            int digit = ch - '0';

            if(res > (Integer.MAX_VALUE - digit) / 10)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            res = res * 10 + digit;
        }

        return res * sign;
    }
}