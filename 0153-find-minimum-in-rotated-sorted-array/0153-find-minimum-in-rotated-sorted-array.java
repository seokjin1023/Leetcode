class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] >= nums[0]) 
                start = mid + 1;
            else 
                end = mid - 1;
        }
        if(start == nums.length) return nums[0];
        return nums[start];
    }
}