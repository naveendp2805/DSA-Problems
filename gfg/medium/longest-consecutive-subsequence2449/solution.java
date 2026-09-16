class Solution {
    public int longestConsecutive(int[] arr) {
        // code here
        Set<Integer> set = new HashSet<>();
        for(int ele : arr)
            set.add(ele);
            
        int res = 0;
        for(int num : set)
        {
            if(!set.contains(num - 1))
            {
                int c = 1;
                int curr = num;
                
                while(set.contains(curr + 1))
                {
                    curr++;
                    c++;
                }
                    
                res = Math.max(res, c);
            }
        }
        
        return res;
    }
}