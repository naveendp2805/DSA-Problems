class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), res = 0;
        int i = 0;

        Set<Character> set = new HashSet<>();

        for(int j=0; j<n; j++)
        {
            char ch = s.charAt(j);

            while(set.contains(ch)) {
                set.remove(s.charAt(i++));
            }

            set.add(ch);

            res = Math.max(res, j - i + 1);
        }

        return res;
    }
}