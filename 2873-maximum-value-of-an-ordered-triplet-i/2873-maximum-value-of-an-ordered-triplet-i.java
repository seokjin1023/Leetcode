class Solution {
    public long maximumTripletValue(int[] nums) {
        long answer = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                long triplet = (long)nums[i] - nums[j];
                if(triplet < 0) continue;
                for(int k = j + 1; k < nums.length; k++) {
                    answer = Math.max(answer, triplet * nums[k]);
                }
            }
        }
        return answer;
    }
}