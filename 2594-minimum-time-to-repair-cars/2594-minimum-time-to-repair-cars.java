class Solution {
    public long repairCars(int[] ranks, int cars) {
        long answer = 0;
        Arrays.sort(ranks);
        long low = 0L;
        long high = (long)ranks[ranks.length - 1] * cars * cars;
        while(low <= high) {
            long time = (low + high) / 2;
            System.out.println(low + " " + high + " " + time);
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