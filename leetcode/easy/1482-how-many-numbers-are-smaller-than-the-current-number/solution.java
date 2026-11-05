class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;

        int[] original = nums.clone();
        int[] res = new int[n];

        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            map.putIfAbsent(nums[i], i);
        }

        for(int i=0; i<n; i++) {
            res[i] = map.get(original[i]);
        }

        return res;
    }
}