class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int answer = 0;
        int second = 0;
        int latestFitIndex = -1;
        int frontBlock = -1;
        while(second < nums.length) {
            if(nums[second] > right) {
                frontBlock = second;
                latestFitIndex = -1;
            }
            if(nums[second] >= left && nums[second] <= right)
                latestFitIndex = second;
            
            int countArray = 0;
            if(latestFitIndex != -1)
                countArray += latestFitIndex - frontBlock; 
            
            if(countArray > 0)
                answer += countArray;
            
            second++;
        }
        return answer;
    }
}