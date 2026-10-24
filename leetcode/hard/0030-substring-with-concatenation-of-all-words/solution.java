class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        int wordLen = words[0].length();
        int wordCount = words.length;
        int n = s.length();

        Map<String, Integer> required = new HashMap<>();
        for(String word : words) {
            required.put(word, required.getOrDefault(word, 0) + 1);
        }

        for(int offset = 0; offset < wordLen; offset++)
        {
            int i = offset;
            int count = 0;
            Map<String, Integer> seen = new HashMap<>();

            for(int j = offset; j+wordLen <= n; j += wordLen)
            {
                String word = s.substring(j, j+wordLen);

                if(!required.containsKey(word))
                {
                    i = j + wordLen;
                    count = 0;
                    seen.clear();
                    continue;
                }

                seen.put(word, seen.getOrDefault(word, 0) + 1);
                count++;

                while(seen.get(word) > required.get(word))
                {
                    String word2 = s.substring(i, i+wordLen);

                    seen.put(word2, seen.get(word2) - 1);
                    count--;
                    i += wordLen;
                }

                if(count == wordCount)
                {
                    res.add(i);

                    String word2 = s.substring(i, i+wordLen);

                    seen.put(word2, seen.get(word2) - 1);
                    count--;
                    i += wordLen;
                }
            }
        }

        return res;    
    }
}