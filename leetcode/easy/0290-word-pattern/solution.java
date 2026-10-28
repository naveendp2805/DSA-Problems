class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s+");
        Map<String, Character> map1 = new HashMap<>();
        Map<Character, String> map2 = new HashMap<>();

        int n = pattern.length();

        if(n != words.length)
            return false;

        for(int i=0; i<n; i++)
        {
            String curr = words[i];
            char ch = pattern.charAt(i);

            if(map1.containsKey(curr) && map1.get(curr) != ch)
                return false;

            if(map2.containsKey(ch) && !map2.get(ch).equals(curr))
                return false;

            map1.put(curr, ch);
            map2.put(ch, curr);
        }

        return true;
    }
}