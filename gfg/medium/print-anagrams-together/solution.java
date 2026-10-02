class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] strs) {
        // code here
        ArrayList<ArrayList<String>> res = new ArrayList<>();

        Map<String, ArrayList<String>> map = new HashMap<>();

        for(String str : strs)
        {
            String lexString = convertToLexString(str);

            map.computeIfAbsent(lexString, k -> new ArrayList<>()).add(str);
        }

        for(ArrayList<String> value : map.values())
            res.add(value);

        return res;
    }

    private static String convertToLexString(String s)
    {
        char[] chars = s.toCharArray();

        Arrays.sort(chars);

        return new String(chars);
    }
}