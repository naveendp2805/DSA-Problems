class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        Integer[] nums = new Integer[n];
        for(int i=0; i<n; i++)
            nums[i] = arr[i];

        Arrays.sort(nums, (a, b) -> {
            int aBits = Integer.bitCount(a);
            int bBits = Integer.bitCount(b);

            if(aBits != bBits) return aBits - bBits;

            return a - b;
        });

        for(int i=0; i<n; i++)
            arr[i] = nums[i];        

        return arr;
    }
}