class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();

        if(m < n) return "";

        Map<Character, Integer> required = new HashMap<>();
        for(char ch : t.toCharArray()) {
            required.put(ch, required.getOrDefault(ch, 0) + 1);
        }

        int i = 0;
        int formed = 0, start = 0, min = Integer.MAX_VALUE;
        StringBuilder str = new StringBuilder();
        Map<Character, Integer> window = new HashMap<>();

        for(int j=0; j<m; j++)
        {
            char ch = s.charAt(j);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if(required.containsKey(ch) && window.get(ch).intValue() == required.get(ch).intValue()) {
                formed++;
            }

            while(formed == required.size())
            {
                int len = j - i + 1;

                if(len < min) {
                    min = len;
                    start = i;
                }

                char leftCh = s.charAt(i++);
                window.put(leftCh, window.get(leftCh) - 1);

                if(required.containsKey(leftCh) && window.get(leftCh) < required.get(leftCh)) {
                    formed--;
                }
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}