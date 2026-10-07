class Solution {
    public String countAndSay(int n) {
        String res = "1";

        for(int i=1; i<n; i++)
        {
            int c = 1;
            StringBuilder temp = new StringBuilder();

            for(int j=1; j<res.length(); j++)
            {
                if(res.charAt(j) == res.charAt(j-1))
                    c++;
                else
                {
                    temp.append(c).append(res.charAt(j-1));
                    c = 1;
                }
            }

            temp.append(c).append(res.charAt(res.length() - 1));
            res = temp.toString();
        }

        return res;
    }
}