class Solution {
    public int findMinimumRemovals(List<int[]> intervalList) {
        // write your code here 
        int n = intervalList.size();
        
        Collections.sort(intervalList, (a, b) -> {
            if(a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        
        int prev = intervalList.get(0)[1], res = 0;
        
        for(int i=1; i<n; i++)
        {
            if(intervalList.get(i)[0] < prev)
            {
                res++;
            } else  
                prev = intervalList.get(i)[1];
        }
        
        return res;
    }
}