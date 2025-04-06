class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int answer = 0;
        while(mainTank >= 5) {
            answer += 50;
            mainTank -= 5;
            if(additionalTank > 0) {
                mainTank += 1;
                additionalTank--;
            }
        }
        answer += mainTank * 10;
        return answer;
    }
}