class Solution {
    public void mergeTwoParts(int[] arr) {
        // code here
        int bp = -1, n = arr.length;
        
        for(int i=1; i<n; i++)
        {
            if(arr[i] < arr[i-1])
            {
                bp = i;
                break;
            }
        }
        
        if(bp == -1) return ;
        
        int[] res = new int[n];
        
        merge(arr, res, bp, n);
        
        for(int i=0; i<n; i++)
            arr[i] = res[i];
        
    }
    
    private void merge(int[] arr, int[] res, int bp, int n)
    {
        int i=0, j = bp, x = 0;
        
        while(i < bp && j < n)
        {
            if(arr[i] < arr[j])
                res[x++] = arr[i++];
            else
                res[x++] = arr[j++];
        }
        
        while(i < bp)
            res[x++] = arr[i++];
            
        while(j < n)
            res[x++] = arr[j++];
    }
}