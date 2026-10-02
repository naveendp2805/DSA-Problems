class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();

        if((n & 1) == 1) return false;

        Stack<Integer> openIndices = new Stack<>();
        Stack<Integer> unlockedIndices = new Stack<>();

        for(int i=0; i<n; i++)
        {
            if(locked.charAt(i) == '0') {
                unlockedIndices.push(i);
            } else if(s.charAt(i) == '(') {
                openIndices.push(i);
            } else {
                if(!openIndices.isEmpty()) {
                    openIndices.pop();
                } else if(!unlockedIndices.isEmpty()) {
                    unlockedIndices.pop();
                } else {
                    return false;
                }
            }
        }

        while(!openIndices.isEmpty() && !unlockedIndices.isEmpty() && openIndices.peek() < unlockedIndices.peek())
        {
            openIndices.pop();
            unlockedIndices.pop();
        }

        if(openIndices.isEmpty() && !unlockedIndices.isEmpty())
            return (unlockedIndices.size() & 1) == 0;

        return openIndices.isEmpty();
    }
}