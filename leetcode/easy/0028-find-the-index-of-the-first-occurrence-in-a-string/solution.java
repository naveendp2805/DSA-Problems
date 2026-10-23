class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.equals(needle))
            return 0;

        int r = needle.length();

        for(int i=0; i<= haystack.length() - r; i++)
        {
            if(haystack.substring(i, i+r).equals(needle))
                return i;
        }

        return -1;
    }
}