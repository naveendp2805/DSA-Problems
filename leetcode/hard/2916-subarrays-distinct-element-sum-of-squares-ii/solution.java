import java.util.*;

class Solution {
    private static final long MOD = 1_000_000_007L;

    public int sumCounts(int[] nums) {
        int n = nums.length;

        SegmentTree tree = new SegmentTree(n);
        Map<Integer, Integer> lastSeen = new HashMap<>();

        long answer = 0;

        for (int i = 0; i < n; i++) {
            int previous = lastSeen.getOrDefault(nums[i], -1);

            // Distinct count increases for these subarrays.
            tree.update(previous + 1, i, 1);

            // Sum of squared distinct counts of subarrays
            // ending at index i.
            answer = (answer + tree.sumSquares()) % MOD;

            lastSeen.put(nums[i], i);
        }

        return (int) answer;
    }

    static class SegmentTree {
        int n;
        long[] sum;
        long[] sumSquares;
        long[] lazy;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sumSquares = new long[4 * n];
            lazy = new long[4 * n];
        }

        void apply(int node, int left, int right, long delta) {
            long len = right - left + 1L;

            long oldSum = sum[node];

            sumSquares[node] = (
                sumSquares[node]
                + 2L * delta % MOD * oldSum % MOD
                + delta * delta % MOD * len % MOD
            ) % MOD;

            sum[node] = (oldSum + delta * len) % MOD;
            lazy[node] = (lazy[node] + delta) % MOD;
        }

        void push(int node, int left, int right) {
            if (lazy[node] == 0 || left == right) {
                return;
            }

            int mid = left + (right - left) / 2;
            long delta = lazy[node];

            apply(node * 2, left, mid, delta);
            apply(node * 2 + 1, mid + 1, right, delta);

            lazy[node] = 0;
        }

        void pull(int node) {
            sum[node] = (
                sum[node * 2] + sum[node * 2 + 1]
            ) % MOD;

            sumSquares[node] = (
                sumSquares[node * 2]
                + sumSquares[node * 2 + 1]
            ) % MOD;
        }

        void update(int ql, int qr, long delta) {
            if (ql > qr) {
                return;
            }

            update(1, 0, n - 1, ql, qr, delta);
        }

        private void update(
            int node, int left, int right,
            int ql, int qr, long delta
        ) {
            if (ql <= left && right <= qr) {
                apply(node, left, right, delta);
                return;
            }

            push(node, left, right);

            int mid = left + (right - left) / 2;

            if (ql <= mid) {
                update(node * 2, left, mid, ql, qr, delta);
            }

            if (qr > mid) {
                update(node * 2 + 1, mid + 1, right, ql, qr, delta);
            }

            pull(node);
        }

        long sumSquares() {
            return sumSquares[1];
        }
    }
}
