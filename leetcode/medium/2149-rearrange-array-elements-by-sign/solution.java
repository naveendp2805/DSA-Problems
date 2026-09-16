class Solution {
    public int[] rearrangeArray(int[] nums) {
        Queue<Integer> positives = new LinkedList<>();
        Queue<Integer> negatives = new LinkedList<>();

        for(int num : nums)
        {
            if(num < 0) negatives.offer(num);
            else positives.offer(num);
        }

        for(int i=0; i<nums.length; i+=2)
        {
            nums[i] = positives.poll();
            nums[i+1] = negatives.poll();
        }

        return nums;
    }
}