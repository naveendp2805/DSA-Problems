class Solution {
    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        // STEP 1: Initialize suffix array
        int[] sa = new int[n];
        int[] rank = nums.clone();

        for (int i = 0; i < n; i++) {
            sa[i] = i;
        }

        // STEP 2: Build suffix array using doubling
        for (int k = 1; k < n; k *= 2) {

            long[] keys = new long[n];

            for (int i = 0; i < n; i++) {

                int first = rank[i] + 1;

                int second = (i + k < n)
                        ? rank[i + k] + 1 : 0;

                keys[i] = ((long) first << 34)
                        | ((long) second << 17)
                        | i;
            }

            Arrays.sort(keys);

            int[] newRank = new int[n];

            for (int i = 0; i < n; i++) {
                sa[i] = (int) (keys[i] & ((1L << 17) - 1));
            }

            int classes = 0;
            newRank[sa[0]] = 0;

            for (int i = 1; i < n; i++) {

                int a = sa[i - 1];
                int b = sa[i];

                int a2 = a + k < n ? rank[a + k] : -1;
                int b2 = b + k < n ? rank[b + k] : -1;

                if (rank[a] != rank[b] || a2 != b2) {
                    classes++;
                }

                newRank[b] = classes;
            }

            rank = newRank;

            if (classes == n - 1) {
                break;
            }
        }

        // STEP 3: Calculate positions
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            pos[sa[i]] = i;
        }

        // STEP 4: Calculate LCP using Kasai algorithm
        int[] lcp = new int[n];

        int h = 0;

        for (int i = 0; i < n; i++) {

            int r = pos[i];

            if (r == 0) {
                h = 0;
                continue;
            }

            int j = sa[r - 1];

            while (i + h < n && j + h < n
                    && nums[i + h] == nums[j + h]) {
                h++;
            }

            lcp[r] = h;

            if (h > 0) {
                h--;
            }
        }

        // STEP 5: Find minimum unique subarray
        int ans = n;

        for (int r = 0; r < n; r++) {

            int left = lcp[r];

            int right = (r + 1 < n)
                    ? lcp[r + 1] : 0;

            int required = Math.max(left, right) + 1;

            int start = sa[r];

            if (start + required <= n) {
                ans = Math.min(ans, required);
            }
        }

        return ans;
    }
}
