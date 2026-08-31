class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs)
        {
            String lexString = convertLexString(str);

            map.computeIfAbsent(lexString, k -> new ArrayList<>()).add(str);
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet())
            res.add(entry.getValue());

        return res;
    }

    private static String convertLexString(String str)
    {
        char[] arr = str.toCharArray();

        Arrays.sort(arr);

        return new String(arr);
    }
}