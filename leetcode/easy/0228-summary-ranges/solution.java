class Solution {
    public List<String> summaryRanges(int[] nums) {
        int  n = nums.length;
        List<String> res = new ArrayList<>();

        if(n == 0) return res;
        
        int prev = nums[0], start = prev;

        for(int i=1; i<n; i++)
        {
            if(nums[i] - 1 != prev) {
                if(start == prev) {
                    res.add(String.valueOf(prev));
                } else {
                    res.add(String.valueOf(start) + "->" + String.valueOf(prev));
                }

                prev = start = nums[i];
            }
            else {
                prev = nums[i];
            }
        }

        if(start == prev) {
            res.add(String.valueOf(prev));
        } else {
            res.add(String.valueOf(start) + "->" + String.valueOf(prev));
        }
        
        return res;
    }
}