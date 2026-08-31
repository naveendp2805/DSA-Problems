class Solution {
    public int uniqueLetterString(String s) {
        int[] prev = new int[26];
        int[] last = new int[26];

        Arrays.fill(prev, -1);
        Arrays.fill(last, -1);

        long res = 0;
        int n = s.length();

        for(int i=0; i<n; i++)
        {
            int ch = s.charAt(i) - 'A';

            if(last[ch] != -1)
            {
                res += (long) (last[ch] - prev[ch]) * (i - last[ch]);
            }

            prev[ch] = last[ch];
            last[ch] = i;
        }

        for(int ch=0; ch<26; ch++)
        {
            if(last[ch] != -1)
            {
                res += (long) (last[ch] - prev[ch]) * (n - last[ch]);
            }
        }

        return (int)res;
    }
}