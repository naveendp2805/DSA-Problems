class Solution {
    public boolean checkString(String s) {
        boolean hasB = false;

        for(char ch : s.toCharArray()) {
            if(ch == 'b') {
                hasB = true;
            } else {
                if(hasB) return false;
            }
        }

        return true;
    }
}