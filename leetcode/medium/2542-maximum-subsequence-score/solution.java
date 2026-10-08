class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        int[][] pairs = new int[n][2];

        for(int i=0; i<n; i++)
        {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(b[1], a[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long res = 0, sum = 0;

        for(int[] pair: pairs)
        {
            int num1 = pair[0];
            int num2 = pair[1];

            pq.offer(num1);
            sum += num1;

            if(pq.size() > k)
                sum -= pq.poll();

            if(pq.size() == k)
                res = Math.max(res, sum * num2);
        }

        return res;
    }
}