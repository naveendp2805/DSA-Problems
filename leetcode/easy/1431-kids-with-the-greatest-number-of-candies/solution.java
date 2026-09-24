class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = 0, n = candies.length;

        for(int candy : candies)
            maxCandy = Math.max(maxCandy, candy);

        List<Boolean> res = new ArrayList<>();

        for(int i=0; i<n; i++)
        {
            res.add(candies[i] + extraCandies >= maxCandy);
        }

        return res;
    }
}