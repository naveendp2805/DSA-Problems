class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);

        if(idx == -1) return word;

        StringBuilder res = new StringBuilder();

        res.append(word.substring(0, idx + 1)).reverse();
        res.append(word.substring(idx + 1, word.length()));

        return res.toString();
    }
}