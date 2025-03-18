//AND 연산을 한 이후 그것을 되돌리고 싶다면 원래 알던 수를 |연산을 통해서 다시 계산하면 되돌아옴.
//a ^ b == a + b일 때 둘의 비트가 겹치지 않는 것!
class Solution {
    public int longestNiceSubarray(int[] nums) {
        Queue<Integer> que = new LinkedList<>();
        int answer = 1;
        int subLength = 1;
        int sum = nums[0];
        que.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            while((sum ^ nums[i]) != sum + nums[i] && !que.isEmpty()) {
                sum ^= que.poll();
                subLength--;
            }
            sum ^= nums[i];
            subLength++;
            que.add(nums[i]);
            answer = Math.max(answer, subLength);
        }
        return answer;
    }
}