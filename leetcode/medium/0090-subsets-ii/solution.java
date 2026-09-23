class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        Arrays.sort(nums);
        createSubset(nums, 0, res, subset);

        return res;
    }

    private static void createSubset(int[] nums, int idx, List<List<Integer>> res, List<Integer> subset)
    {
        if(idx == nums.length)
        {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[idx]);
        createSubset(nums, idx+1, res, subset);

        subset.remove(subset.size() - 1);

        while(idx+1 < nums.length && nums[idx] == nums[idx+1])
            idx++;

        createSubset(nums, idx+1, res, subset);
    }
}
