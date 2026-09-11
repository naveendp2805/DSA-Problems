class Solution {
    public int pairCount(int x, int y) {
        // code here
        if(y % x != 0) return 0;
        
        int k = y / x;
        int res = 0;
        
        for(int i=2; i*i<=k; i++)
        {
            if(k % i == 0) 
                res++;
            
            while(k % i == 0) 
                k /= i;
        }
        
        if(k > 1) res++;
        
        return 1 << res;
    }
}