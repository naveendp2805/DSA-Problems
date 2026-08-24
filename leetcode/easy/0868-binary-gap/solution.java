class Solution {
    public int binaryGap(int n) {
        int sIndex=-1, i=0, maxLen = 0;

        while(n > 0)
        {
            if((n & 1) == 1)
            {
                if(sIndex != -1)
                    maxLen = Math.max(maxLen, i - sIndex);

                sIndex = i;
            }

            n >>>= 1;
            i++;
        }

        return maxLen;
    }
}