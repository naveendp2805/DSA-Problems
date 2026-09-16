class Solution {
    public String largestOddNumber(String num) {
        int i=num.length() - 1;

        while(i >= 0)
        {
            int ch = num.charAt(i) - '0';
            if((ch & 1) == 1)
                break;

            i--;
        }

        return i >= 0 ? num.substring(0, i+1) : "";
    }
}