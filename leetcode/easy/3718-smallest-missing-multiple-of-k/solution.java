class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);

        int res = k;
        while(set.contains(res))
            res += k;

        return res;
    }
}