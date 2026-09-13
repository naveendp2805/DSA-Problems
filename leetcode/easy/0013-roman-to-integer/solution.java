class Solution {
    public int romanToInt(String s) {
        int n = s.length(), res = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for(int i=0; i<n; i++)
        {
            int curr = map.get(s.charAt(i));
            int next = i+1 < n ? map.get(s.charAt(i+1)) : 0;

            if(curr < next) {
                res += (next - curr);
                i++;
            } else {
                res += curr;
            }
        }

        return res;
    }
}