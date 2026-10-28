class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);

        while(n > 1)
        {
            n = sumOfSquares(n);

            if(!set.add(n))
                return false;
        }

        return true;
    }

    private int sumOfSquares(int n)
    {
        int res = 0;

        while(n > 0)
        {
            int r = n % 10;
            res += r * r;
            n /= 10;
        }

        return res;
    }
}