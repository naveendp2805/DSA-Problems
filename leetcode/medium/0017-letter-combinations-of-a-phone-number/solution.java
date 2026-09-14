class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        buildCombinations(digits, 0, new StringBuilder(), res, map);

        return res;
    }

    private static void buildCombinations(String digits, int idx, StringBuilder combination, List<String> res, Map<Character, String> map)
    {
        if(idx == digits.length())
        {
            res.add(combination.toString());
            return;
        }

        String letters = map.get(digits.charAt(idx));

        for(char letter : letters.toCharArray())
        {
            combination.append(letter);

            buildCombinations(digits, idx+1, combination, res, map);

            combination.deleteCharAt(combination.length() - 1);
        }
    }
}