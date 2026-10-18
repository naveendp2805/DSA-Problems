class Solution {
    static final int mod = 1_000_000_007;
    int[][] comb;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        comb = new int[n+1][n+1];

        for(int i=0; i<=n; i++)
        {
            comb[i][0] = 1;
            comb[i][i] = 1;

            for(int j=1; j<i; j++) {
                comb[i][j] = (comb[i-1][j-1] + comb[i-1][j]) % mod;
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for(int num : nums)
            arr.add(num);

        return (int) ((ways(arr) - 1) % mod);
    }

    private long ways(ArrayList<Integer> arr)
    {
        int n = arr.size();

        if(n <= 2) return 1;

        int root = arr.get(0);

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for(int i=1; i<n; i++)
        {
            int ele = arr.get(i);

            if(ele < root) left.add(ele);
            else right.add(ele);
        }

        long leftWays = ways(left);
        long rightWays = ways(right);

        long chosen = comb[left.size() + right.size()][left.size()];

        return chosen * leftWays % mod * rightWays % mod;
    }
}