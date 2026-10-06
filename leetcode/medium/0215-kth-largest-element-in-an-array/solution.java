class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0, n = nums.length;

        for(int i=0; i<k; i++) {
            pq.offer(nums[i]);
        }

        for(int i=k; i<n; i++)
        {
            if(nums[i] > pq.peek())
            {
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return pq.peek();
    }
}