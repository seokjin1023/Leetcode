//핵심 아이디어: n 개중 n - 1개에 1을 더할 수 있다는 것 = 자기 자신만 1을 뺄 수 있음.
//가장 최솟값과 자신만의 차이를 계속 더해나가면 답이 됨.
//즉, 모든 값을 더하고 최솟값을 n번 곱해서 빼주면 됨.

class Solution {
    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int sum = Arrays.stream(nums).sum();
        return sum - min * nums.length;
    }
}