class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int res = 0;

        for(int k=1; k<=n; k++)
        {
            if(n % k != 0)
                continue;

            boolean sortable = true;
            int prevMax = Integer.MIN_VALUE;
            
            for(int start = 0; start < n; start += k)
            {
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
                int descents = 0;

                for(int j=0; j<k; j++)
                {
                    int curr = nums[start + j];
                    int next = nums[start + (j + 1) % k];

                    if(curr > next)
                        descents++;

                    min = Math.min(min, curr);
                    max = Math.max(max, curr);
                }

                if(descents > 1 || prevMax > min)
                {
                    sortable = false;
                    break;
                }

                prevMax = max;
            }

            if(sortable)
                res += k;
        }

        return res;
    }
}