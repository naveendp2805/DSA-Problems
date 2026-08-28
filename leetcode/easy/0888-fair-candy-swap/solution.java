class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        Set<Integer> set = new HashSet<>();
        int sum1 = 0, sum2 = 0;

        for(int x : aliceSizes)
            sum1 += x;

        for(int x : bobSizes)
        {
            set.add(x);
            sum2 += x;
        }

        int diff = (sum2 - sum1) / 2;

        for(int x : aliceSizes)
        {
            if(set.contains(x + diff))
                return new int[] {x, x + diff};
        }

        return new int[] {};
    }
}