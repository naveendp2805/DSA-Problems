class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : deck)
            map.put(x, map.getOrDefault(x, 0) + 1);

        int res = 0;
        for(int x : map.values())
            res = gcd(x, res);

        return res > 1;
    }

    private static int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}