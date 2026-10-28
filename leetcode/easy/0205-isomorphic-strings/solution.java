class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();

        int[] freq1 = new int[128], freq2 = new int[128];

        for(int i=0; i<n; i++)
        {
            char a = s.charAt(i), b = t.charAt(i);

            if(freq1[a] != 0 && freq1[a] != b)
                return false;

            if(freq2[b] != 0 && freq2[b] != a)
                return false;

            freq1[a] = b;
            freq2[b] = a;
        }

        return true;
    }
}