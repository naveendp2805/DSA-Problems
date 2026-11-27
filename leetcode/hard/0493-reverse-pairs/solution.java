class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {

        if(low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;

        int count = mergeSort(nums, low, mid);

        count += mergeSort(nums, mid + 1, high);

        count += countPairs(nums, low, mid, high);

        merge(nums, low, mid, high);

        return count;
    }

    private int countPairs(int[] nums, int low, int mid, int high) {

        int right = mid + 1;
        int count = 0;

        for(int i=low; i<=mid; i++) {
            
            while(right <= high && (long) nums[i] > 2L * nums[right]) {
                right++;
            }

            count += right - (mid + 1);
        }

        return count;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int i = low, j = mid + 1, x = 0;

        while(i <= mid && j <= high) {
            
            if(nums[i] <= nums[j]) {
                temp[x++] = nums[i++];
            } else {
                temp[x++] = nums[j++];
            }
        }

        while(i <= mid) {
            temp[x++] = nums[i++];
        }

        while(j <= high) {
            temp[x++] = nums[j++];
        }

        for(int k=0; k<temp.length; k++) {
            nums[low + k] = temp[k];
        }
    }
}