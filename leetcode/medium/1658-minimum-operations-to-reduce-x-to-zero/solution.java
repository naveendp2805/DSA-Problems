class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int totalSum = 0;

        for(int num : nums)
            totalSum += num;

        int target = totalSum - x;

        if(target == 0) return n;

        int cSum = 0, i = 0, maxLen = 0;

        for(int j=0; j<n; j++)
        {
            cSum += nums[j];

            while(i<n && cSum > target)
                cSum -= nums[i++];

            if(cSum == target)
                maxLen = Math.max(maxLen, j-i+1);
        }

        return maxLen == 0 ? -1 : n - maxLen;
    }
}