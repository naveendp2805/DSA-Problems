class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String res = "";
        int ones = 0, i=0, n = s.length();

        for(int j=0; j<n; j++)
        {
            int ch = s.charAt(j) - '0';

            if(ch == 1) ones++;

            while(ones > k)
            {
                if(s.charAt(i) == '1') 
                    ones--;
                i++;
            }

            while(ones == k && s.charAt(i) == '0') i++;

            if(ones == k)
            {
                String beautiful = s.substring(i, j+1);
                int m = beautiful.length();

                if(res.isEmpty() || m < res.length() || (m == res.length() && beautiful.compareTo(res) < 0))
                    res = beautiful;
            }
        }

        return res;
    }
}