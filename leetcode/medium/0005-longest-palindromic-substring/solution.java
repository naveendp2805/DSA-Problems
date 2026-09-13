class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 1, n = s.length();
        String maxStr = s.substring(0, 1);

        for(int i=0; i<n; i++)
        {
            for(int j=i+maxLen; j<=n; j++)
            {
                String sub = s.substring(i, j);

                if(j - i > maxLen && isPallindrome(sub))
                {
                    maxLen = j - i;
                    maxStr = sub;
                }
            }
        }

        return maxStr;
    }

    private static boolean isPallindrome(String s)
    {
        int i=0, j=s.length() - 1;

        while(i < j)
        {
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }

        return true;
    }
}