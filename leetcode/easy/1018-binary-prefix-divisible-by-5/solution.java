class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int rem = 0;

        for(int num : nums)
        {
            rem = (2 * rem + num) % 5;

            res.add(rem == 0);
        }

        return res;
    }
}