class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0 || k == 1)
            return 0;
        int answer = 0;
        int product = 1;
        Queue<Integer> que = new LinkedList<>();
        for(int num : nums) {
            if(num >= k) {
                while(!que.isEmpty()) {
                    answer += que.size();
                    product /= que.poll();
                }
            }
            else {
                while(product * num >= k) {
                    answer += que.size();
                    product /= que.poll();
                }
                product *= num;
                que.add(num);
            }
        }
        while(!que.isEmpty()) {
            answer += que.size();
            que.poll();
        }
        return answer;
    }
}