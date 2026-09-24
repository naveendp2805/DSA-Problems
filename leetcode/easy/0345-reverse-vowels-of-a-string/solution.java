class Solution {
    public String reverseVowels(String s) {
        int i=0, j=s.length()-1;
        char[] chars = s.toCharArray();

        while(i < j)
        {
            char ch1 = chars[i], ch2 = chars[j];

            boolean left = isVowel(ch1);
            boolean right = isVowel(ch2);

            if(left && right)
            {
                char temp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = temp; 
            } else if(left)
                j--;
            else i++;
        }

        return new String(chars);
    }

    private static boolean isVowel(char ch)
    {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
            ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            return true;

        return false;
    }
}