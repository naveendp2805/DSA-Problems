class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

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
        createSubset(nums, idx+1, res, subset);
    }
}