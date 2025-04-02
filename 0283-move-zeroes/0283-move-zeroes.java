class Solution {
    public void moveZeroes(int[] nums) {
        int i = Integer.MAX_VALUE, j = 0;
        for(int k = 0; k < nums.length; k++) {
            if(nums[k] == 0) {
                i = k;
                j = k + 1;
                break;
            }
        }
        if(i == Integer.MAX_VALUE) return ;
        while(j < nums.length) {
            if(nums[j] != 0) {
                nums[i++] = nums[j];
                nums[j] = 0;
            }
            j++;
        }
    }
}