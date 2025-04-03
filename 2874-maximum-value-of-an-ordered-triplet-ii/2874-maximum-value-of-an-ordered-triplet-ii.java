class Solution {
    public long maximumTripletValue(int[] nums) {
        long answer = 0;
        int[] prefixMax = new int[nums.length];
        int[] suffixMax = new int[nums.length];
        prefixMax[0] = nums[0];
        suffixMax[nums.length - 1] = nums[nums.length - 1];
        for(int i = 1; i < nums.length; i++)
            prefixMax[i] = Math.max(nums[i], prefixMax[i - 1]);
        for(int i = nums.length - 2; i >= 0; i--)
            suffixMax[i] = Math.max(nums[i], suffixMax[i + 1]);
        
        for(int j = 1; j < nums.length - 1; j++)
            answer = Math.max(answer, (long)(prefixMax[j - 1] - nums[j]) * suffixMax[j + 1]);
        return answer;
    }
}