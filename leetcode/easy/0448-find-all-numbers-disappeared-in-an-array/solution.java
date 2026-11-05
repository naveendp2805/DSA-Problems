class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        for(int num : nums) {
            set.add(num);
        }

        for(int i=0; i<nums.length; i++)
        {
            if(!set.contains(i+1)) {
                res.add(i+1);
            }
        }

        return res;
    }
}