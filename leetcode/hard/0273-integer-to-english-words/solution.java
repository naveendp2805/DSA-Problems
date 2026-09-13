class Solution {
    public String numberToWords(int num) {
        if(num == 0) return "Zero";

        String res = helper(num%1000);
        num /= 1000;

        if(num>0 && num%1000 > 0)
            res = helper(num%1000) + "Thousand " + res;
        num /= 1000;

        if(num>0 && num%1000 > 0)
            res = helper(num%1000) + "Million " + res;
        num /= 1000;

        if(num > 0)
            res = helper(num) + "Billion " + res;
            
        return res.trim();        
    }

    private static String helper(int n)
    {
        String[] digitString = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

        String[] teenString = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
                                 "Seventeen", "Eighteen", "Nineteen"};

        String[] tenString = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
                             "Ninety"};

        String res = "";

        if(n > 99)
            res += digitString[n/100] + " Hundred ";
        n %= 100;

        if(n > 9 && n < 20)
            res += teenString[n%10] + " ";
        else
        {
            if(n > 19)
                res += tenString[n/10] + " ";
            n %= 10;

            if(n > 0)
                res += digitString[n] + " ";
        }

        return res;
    }
}