class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Collections.reverseOrder()
        );
        int[] deltaArray = new int[nums.length + 1];
        int operations = 0;

        for (int i = 0, j = 0; i < nums.length; i++) {
            operations += deltaArray[i];
            //해당 index로 시작하는 interval을 모두 heap에 집어넣기
            while (j < queries.length && queries[j][0] == i) {
                pq.offer(queries[j][1]);
                j++;
            }
            //nums를 zero로 만들 수 있을 때까지 operation을 더해줌
            //deltaArray의 endIndex + 1을 -1함으로써 나중에 interval 종료시 zero로 만들 수 있는 최대치값을 내려줌.
            while (operations < nums[i] && !pq.isEmpty() && pq.peek() >= i) {
                operations += 1;
                deltaArray[pq.poll() + 1] -= 1;
            }
            //zero-array를 만들 수 있는지 확인
            if (operations < nums[i]) {
                return -1;
            }
        }
        return pq.size();
    }
}