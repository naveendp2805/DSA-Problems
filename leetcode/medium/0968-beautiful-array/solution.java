class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);

        while(res.size() < n) {
            List<Integer> temp = new ArrayList<>();

            for(int x : res) {
                int odd = 2 * x - 1;

                if(odd <= n) {
                    temp.add(odd);
                }
            }

            for(int x : res) {
                int even = 2 * x;

                if(even <= n) {
                    temp.add(even);
                }
            }

            res = temp;
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}