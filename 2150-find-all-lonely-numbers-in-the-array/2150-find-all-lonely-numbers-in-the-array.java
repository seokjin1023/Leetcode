class Solution {
    public List<Integer> findLonely(int[] nums) {
        if(nums.length == 1) return List.of(nums[0]);
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if ((i == 0 || nums[i] - nums[i - 1] > 1) &&
                (i == nums.length - 1 || nums[i + 1] - nums[i] > 1)) {
                answer.add(nums[i]);
            }
        }
        return answer;
    }
}