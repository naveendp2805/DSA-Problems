class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for(int num : arr)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        Set<Integer> uniqueOcc = new HashSet<>();
        for(int value : freq.values())
        {
            if(!uniqueOcc.add(value))
                return false;
        }
            
        return true;
    }
}