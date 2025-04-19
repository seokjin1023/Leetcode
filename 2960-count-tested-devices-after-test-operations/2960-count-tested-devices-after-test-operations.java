class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int answer = 0;
        for(int i = 0; i < batteryPercentages.length; i++) {
            if(batteryPercentages[i] >= 1) {
                answer++;
                for(int j = i + 1; j < batteryPercentages.length; j++) {
                    if(batteryPercentages[j] >= 1)
                        batteryPercentages[j]--;
                }
            }
        }
        return answer;
    }
}