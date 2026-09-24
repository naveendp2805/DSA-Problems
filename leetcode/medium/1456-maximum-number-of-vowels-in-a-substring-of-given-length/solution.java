class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int c = 0;
        int res = 0;

        for(int i=0; i<k; i++)
            if(isVowel(s.charAt(i)))
                c++;

        res = c;

        for(int i=k; i<n; i++)
        {
            if(isVowel(s.charAt(i-k))) c--;

            if(isVowel(s.charAt(i))) c++;

            res = Math.max(res, c);
        }

        return res;
    }

    private static boolean isVowel(char ch)
    {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}