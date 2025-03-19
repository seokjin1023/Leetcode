//앞뒤에서 0으로 된 처음, 마지막 index찾고
//그 index가 flip했을 때 가능한지 찾기..?
class Solution {
    public int minOperations(int[] nums) {
        int answer = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] == 0) {
                nums[i] = 1;
                nums[i + 1] = nums[i + 1] == 1 ? 0 : 1;
                nums[i + 2] = nums[i + 2] == 1 ? 0 : 1;
                answer++;
            }
        }
        for(int num : nums) {
            if(num == 0)
                return -1;
        }
        return answer;
    }
}