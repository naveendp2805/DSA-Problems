class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] sorted = nums.clone();
        int n = nums.length;

        Arrays.sort(sorted);

        List<List<Integer>> groups = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int group = -1;
        for(int i=0; i<n; i++)
        {
            if(i == 0 || sorted[i] - sorted[i-1] > limit)
            {
                groups.add(new ArrayList<>());
                group++;
            }

            groups.get(group).add(sorted[i]);
            map.put(sorted[i], group);
        }

        int[] idx = new int[groups.size()];

        for(int i=0; i<n; i++)
        {
            int currGroup = map.get(nums[i]);
            nums[i] = groups.get(currGroup).get(idx[currGroup]);
            idx[currGroup]++;
        }

        return nums;
    }
}