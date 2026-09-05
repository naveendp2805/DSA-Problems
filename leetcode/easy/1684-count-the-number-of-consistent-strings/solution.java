class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        int allowedMask = 0;
        for(char ch : allowed.toCharArray())
            allowedMask |= 1 << (ch - 'a');

        for(String word : words)
        {
            int wordMask = 0;
            for(char ch : word.toCharArray())
                wordMask |= 1 << (ch - 'a');

            if((wordMask & allowedMask) == wordMask)
                res++;
        }

        return res;
    }
}