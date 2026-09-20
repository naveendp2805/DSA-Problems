class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int res = 0;

        for(int i=0; i<n; i++)
        {
            int idx = s.charAt(i) - 'a';

            res += ((26 - idx) * (i+1));
        }

        return res;
    }
}