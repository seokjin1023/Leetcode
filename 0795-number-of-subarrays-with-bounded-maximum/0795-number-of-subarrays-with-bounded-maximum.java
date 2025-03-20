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
            
            int countArray = Math.min(second + 1, latestFitIndex + 1);
            
            countArray -= frontBlock + 1; //만약 right보다 높은 수가 중간에 존재하면 그 이후만 계산
            
            if(countArray > 0)
                answer += countArray;
            
            second++;
        }
        return answer;
    }
}