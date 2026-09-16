class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();

        int[] freqS = new int[128];
        int[] freqT = new int[128];

        for(int i=0; i<n; i++)
        {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if(freqS[a] != 0 && freqS[a] != b)
                return false;
            
            if(freqT[b] != 0 && freqT[b] != a)
                return false;

            freqS[a] = b;
            freqT[b] = a;
        }

        return true;
    }
}