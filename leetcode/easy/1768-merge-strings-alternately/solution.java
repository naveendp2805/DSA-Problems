class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int i=0, j=0;

        StringBuilder res = new StringBuilder();

        while(i < n1 && j < n2)
        {
            res.append(word1.charAt(i++));
            res.append(word2.charAt(j++));
        }

        while(i < n1)
            res.append(word1.charAt(i++));

        while(j < n2)
            res.append(word2.charAt(j++));

        return res.toString();
    }
}