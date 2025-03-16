class Solution {
    public long repairCars(int[] ranks, int cars) {
        long answer = 0;
        long low = 0L;
        long high = (long)ranks[0] * cars * cars;
        while(low <= high) {
            long time = (low + high) / 2;
            long canRepair = 0;
            for(int rank : ranks) {
                canRepair += (long)Math.sqrt(time / rank);
            }
            if(canRepair >= cars) {
                answer = time;
                high = time - 1;
            }
            else {
                low = time + 1;
            }
        }
        return answer;
    }
}