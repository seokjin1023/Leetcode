class Solution {
    public long[] distance(int[] nums) {
        long[] answer = new long[nums.length];
        Map<Integer, Deque<long[]>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            Deque<long[]> deque = map.computeIfAbsent(nums[i], k -> new LinkedList<>());
            long[] last = deque.isEmpty() ? new long[]{0L, 0L} : deque.getLast();
            deque.offerLast(new long[]{last[0] + i, last[1] + 1});
            map.put(nums[i], deque);
        }
        for(int i = 0; i < nums.length; i++) {
            Deque<long[]> deque = map.get(nums[i]);
            long[] value = deque.pollFirst();
            long frontSum = value[0] - i;
            long sum;
            if(deque.isEmpty()) {
                sum = Math.abs(frontSum - i * (value[1] - 1));
            } 
            else {
                long backSum = deque.getLast()[0] - value[0];
                sum = Math.abs(frontSum - i * (value[1] - 1)) + backSum - i * (deque.getLast()[1] - value[1]);
            }
            answer[i] = sum;
        }
        return answer;
    }
}