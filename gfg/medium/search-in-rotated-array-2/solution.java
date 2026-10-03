class Solution {
    public boolean search(int[] arr, int target) {
        // code here
        int l=0, h=arr.length-1;
        while(l <= h)
        {
            int mid = l + (h-l)/2;
            if(target == arr[mid])
                return true;
            if(arr[l] == arr[mid] && arr[h] == arr[mid])
            {
                l++;
                h--;
            }
            else if(arr[l] <= arr[mid])
            {
                if(target >= arr[l] && target < arr[mid])
                    h = mid-1;
                else l = mid+1;
            }
            else 
            {
                if(target <= arr[h] && target > arr[mid])
                    l = mid + 1;
                else h = mid - 1;
            }
        }
        
        return false;
    }
}
