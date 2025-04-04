class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int answer = 1;
        int count = 1;
        boolean isIncreasing = true;
        for(int i = 1; i < nums.length; i++) {
            if(count == 1) {
                if(nums[i] == nums[i - 1])
                    continue;
                if(nums[i] > nums[i - 1])
                    isIncreasing = true;
                else
                    isIncreasing = false;
                count++;
                answer = Math.max(answer, count);
                continue;
            }
            if(isIncreasing) {
                if(nums[i] > nums[i - 1])
                    count++;
                else if(nums[i] == nums[i - 1])
                    count = 1;
                else {
                    count = 2;
                    isIncreasing = false;
                }
            }
            else {
                if(nums[i] < nums[i - 1])
                    count++;
                else if(nums[i] == nums[i - 1])
                    count = 1;
                else {
                    count = 2;
                    isIncreasing = true;
                }
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }
}