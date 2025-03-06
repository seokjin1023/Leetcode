class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        List<Integer> zipNums = new ArrayList<>();
        int answer = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums) {
            if(sum == 0) {
                sum += num;
            }
            else if((sum ^ num) < 0) {
                zipNums.add(sum);
                sum = num;
            }
            else
                sum += num;
            answer = Math.max(answer, num);
        }
        zipNums.add(sum);
        if(zipNums.size() == 1) {
            if(zipNums.get(0) < 0)
                return answer;
            else
                return zipNums.get(0);
        }
        
        for(int i = 0; i < zipNums.size(); i++) {
            sum = 0;
            for(int j = 0; j < zipNums.size(); j++) { //j는 subarray 길이
                int value = zipNums.get((i + j) % zipNums.size());
                sum += value;
                answer = Math.max(answer, sum);
            }
        }
        return answer;
    }
}