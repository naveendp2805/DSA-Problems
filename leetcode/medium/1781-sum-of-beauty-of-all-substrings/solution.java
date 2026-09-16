class Solution {
    public int beautySum(String s) {
        int res = 0, n = s.length();

        for(int i=0; i<n; i++)
        {
            int[] freq = new int[26];

            for(int j=i; j<n; j++)
            {
                freq[s.charAt(j) - 'a']++;

                res += findBeauty(freq);
            }
        }

        return res;
    }

    private int findBeauty(int[] freq) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int i=0; i<26; i++)
        {
            if(freq[i] > 0)
            {
                min = Math.min(min, freq[i]);
                max = Math.max(max, freq[i]);
            }
        }

        return max - min;
    }
}