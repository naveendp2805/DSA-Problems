class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for(int i=1; i<n; i++) {
            min = Math.min(min, arr[i] - arr[i-1]);
        }

        for(int i=1; i<n; i++) {
            if(arr[i] - arr[i-1] == min) {
                res.add(new ArrayList<>(Arrays.asList(arr[i-1], arr[i])));
            }
        }
        
        return res;
    }
}