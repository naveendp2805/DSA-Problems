class Solution {
    public boolean isSubsequence(String s, String t) {
        int n1 = s.length(), n2 = t.length();

        if(n1 == 0) return true;
        
        int i=0, j=0;

        while(j < n2)
        {
            if(s.charAt(i) == t.charAt(j))
            {
                i++;
                if(i == n1) return true;
            }
            j++;
        }

        return false;
    }
}