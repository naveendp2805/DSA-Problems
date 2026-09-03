class Solution {
    public boolean uniformArray(int[] nums1) {
        int odd = 0, min = Integer.MAX_VALUE;

        for(int num : nums1)
        {
            odd |= (num & 1);
            min = Math.min(min, num);
        }

        return (min & 1) == odd;
    }
}