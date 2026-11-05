class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;

        for(int x1 : arr1)
        {
            boolean isGreater = true;

            for(int x2 : arr2)
            {
                if(Math.abs(x1 - x2) <= d)
                {
                    isGreater = false;
                    break;
                }
            }

            if(isGreater) {
                res++;
            }
        }

        return res;
    }
}