class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int[] sum = new int[nums.length];
        for(int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] - nums[i - 1] + sum[i - 1];
        }
        return Arrays.stream(sum).sum();
    }
}