class Solution {
    public int sumCounts(List<Integer> nums) {
        int res = 0, n = nums.size();

        for(int i=0; i<n; i++)
        {
            Set<Integer> set = new HashSet<>();

            for(int j=i; j<n; j++)
            {
                set.add(nums.get(j));

                int dv = set.size();
                res += dv * dv;
            }
        }

        return res;
    }
}