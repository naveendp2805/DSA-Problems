
class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        int q = queries.length;
        int[] ans = new int[q];

        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        Integer[] indices = new Integer[q];

        for (int i = 0; i < q; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> Integer.compare(queries[a], queries[b]));

        int[] freq = new int[n + 1];

        int left = 0;
        int right = 0;
        int activeServers = 0;

        for (int idx : indices) 
        {
            long start = (long) queries[idx] - x;
            long end = queries[idx];

            while (right < logs.length && logs[right][1] <= end) 
            {
                int server = logs[right][0];

                if (freq[server] == 0) {
                    activeServers++;
                }

                freq[server]++;
                right++;
            }

            while (left < right && logs[left][1] < start) 
            {
                int server = logs[left][0];

                freq[server]--;

                if (freq[server] == 0) {
                    activeServers--;
                }

                left++;
            }

            ans[idx] = n - activeServers;
        }

        return ans;
    }
}
