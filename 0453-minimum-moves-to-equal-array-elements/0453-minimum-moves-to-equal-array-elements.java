class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            answer += (nums[i + 1] - nums[i]) * (nums.length - 1 - i);
        }
        return answer;
    }
}