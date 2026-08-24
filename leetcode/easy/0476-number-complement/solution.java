class Solution {
    public int findComplement(int num) {
        int res = 0, i=0;

        while(num > 0)
        {
            if((num & 1) == 0)
                res += (int)Math.pow(2, i);

            num >>>= 1;
            i++;
        }

        return res;
    }
}