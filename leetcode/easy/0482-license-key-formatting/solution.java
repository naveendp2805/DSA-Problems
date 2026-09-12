class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int n = s.length(), c = 0;;
        s = s.toUpperCase();

        StringBuilder res = new StringBuilder();

        for(int i=n-1; i>=0; --i)
        {
            char ch = s.charAt(i);

            if(ch == '-') continue;

            if(c == k)
            {
                res.append("-");
                c = 0;
            }

            res.append(ch);
            c++;
        }

        return res.reverse().toString();
    }
}