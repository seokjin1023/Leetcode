class Solution {
    public List<Integer> findLonely(int[] nums) {
        if(nums.length == 1) return List.of(nums[0]);
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(nums);
        if(nums[1] - nums[0] > 1) answer.add(nums[0]);
        for(int i = 1; i < nums.length - 1; i++) {
            if(nums[i] - nums[i - 1] > 1 && nums[i + 1] - nums[i] > 1)
                answer.add(nums[i]);
        }
        if(nums[nums.length - 1] - nums[nums.length - 2] > 1)
            answer.add(nums[nums.length - 1]);
        return answer;
    }
}