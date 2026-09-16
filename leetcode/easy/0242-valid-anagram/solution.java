class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq1 = countFreq(s);
        int[] freq2 = countFreq(t);

        return Arrays.equals(freq1, freq2);
    }

    private static int[] countFreq(String s)
    {
        int[] freq = new int[26];

        for(char ch : s.toCharArray())
            freq[ch - 'a']++;

        return freq;
    }
}