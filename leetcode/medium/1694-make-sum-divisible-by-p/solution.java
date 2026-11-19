class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long totalSum = 0;

        for(int num : nums) {
            totalSum += num;
        }

        int target = (int) (totalSum % p);

        if(target == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        long prefixSum = 0;
        int minLen = n;

        for(int i=0; i<n; i++)
        {
            prefixSum += nums[i];

            int rem = (int) (prefixSum % p);
            int req = (rem - target + p) % p;

            if(map.containsKey(req)) {
                int len = i - map.get(req);
                minLen = Math.min(len, minLen);
            }

            map.put(rem, i);
        }

        return minLen == n ? -1 : minLen;
    }
}