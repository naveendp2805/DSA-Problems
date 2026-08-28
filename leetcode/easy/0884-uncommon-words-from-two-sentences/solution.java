class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        String[] s = s1.split(" ");
        String[] t = s2.split(" ");

        for(String str : s)
            map.put(str, map.getOrDefault(str, 0) + 1);

        for(String str : t)
            map.put(str, map.getOrDefault(str, 0) + 1);

        for(Map.Entry<String, Integer> entry : map.entrySet())
            if(entry.getValue() == 1)
                res.add(entry.getKey());

        return res.toArray(new String[0]);
    }
}