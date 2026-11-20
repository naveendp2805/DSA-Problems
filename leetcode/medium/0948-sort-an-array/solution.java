class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        int[] temp = new int[n];

        mergeSort(nums, temp, 0, n-1);

        return nums;
    }

    private void mergeSort(int[] nums, int[] temp, int left, int right)
    {
        if(left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(nums, temp, left, mid);
        mergeSort(nums, temp, mid+1, right);

        merge(nums, temp, left, mid, right);
    }

    private void merge(int[] nums, int[] temp, int left, int mid, int right)
    {
        int i = left;
        int j = mid + 1;
        int x = left;

        while(i <= mid && j <= right) 
        {
            if(nums[i] <= nums[j]) {
                temp[x++] = nums[i++];
            } else {
                temp[x++] = nums[j++];
            }
        }

        while(i <= mid) {
            temp[x++] = nums[i++];
        }
        
        while(j <= right) {
            temp[x++] = nums[j++];
        }

        for(i=left; i<=right; i++) {
            nums[i] = temp[i];
        }
    }
}