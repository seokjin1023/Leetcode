class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        if(nums[nums.length - 1] <= 0)
            return 0;
        
        int answer = 0;
        long sum = 0L;
        for(int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            sum += (long)num;
            if(sum <= 0)
                break;
            answer++;
        }
        return (int)answer;
    }
}