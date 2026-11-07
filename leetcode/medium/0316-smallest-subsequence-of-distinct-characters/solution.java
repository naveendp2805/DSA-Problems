
class Solution {
    public String removeDuplicateLetters(String s) {

        int[] freq = new int[26];
        boolean[] seen = new boolean[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {

            freq[ch - 'a']--;

            if (seen[ch - 'a']) {
                continue;
            }

            while (stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > ch &&
                   freq[stack.charAt(stack.length() - 1) - 'a'] > 0) {

                char removed = stack.charAt(stack.length() - 1);

                stack.deleteCharAt(stack.length() - 1);

                seen[removed - 'a'] = false;
            }

            stack.append(ch);
            seen[ch - 'a'] = true;
        }

        return stack.toString();
    }
}
