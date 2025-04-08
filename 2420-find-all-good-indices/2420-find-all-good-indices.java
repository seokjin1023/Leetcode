class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        //k >= num.length - k이면 빈 List 내보내기
        List<Integer> answer = new ArrayList<>();

        int[] nonIncrease = new int[nums.length - k];
        int[] nonDecrease = new int[nums.length];
        nonDecrease[nums.length - 1] = 1;
        nonIncrease[0] = 1;
        for(int i = 1; i < nums.length - k; i++) {
            if(nums[i] <= nums[i - 1])
                nonIncrease[i] = nonIncrease[i - 1] + 1;
            else
                nonIncrease[i] = 1;
        }
        for(int i = nums.length - 2; i > k; i--) {
            if(nums[i] <= nums[i + 1])
                nonDecrease[i] = nonDecrease[i + 1] + 1;
            else
                nonDecrease[i] = 1;
        }

        for(int i = k; i < nums.length - k; i++) {
            if(nonIncrease[i - 1] >= k && nonDecrease[i + 1] >= k)
                answer.add(i);
        }
        return answer;

    }
}