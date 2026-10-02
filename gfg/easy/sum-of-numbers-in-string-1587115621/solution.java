class Solution {
    public static int findSum(String s) {
        // code here
        int res = 0, sum = 0;
        
        for(char ch : s.toCharArray())
        {
            if(Character.isDigit(ch)) {
                sum = sum * 10 + (ch - '0');
            } else {
                res += sum;
                sum = 0;
            }
        }
        
        if(sum > 0)
            res += sum;
            
        return res;
    }
}