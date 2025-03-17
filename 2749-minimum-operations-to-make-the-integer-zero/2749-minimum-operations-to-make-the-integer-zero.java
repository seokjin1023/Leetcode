class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        
        long firstNum = (long)num1;
        long secondNum = (long)num2;
        
        int answer = 1;
        boolean canMake = false;
        while(true) {
            firstNum -= secondNum;
            if(firstNum < answer) return -1;

            int bitOfNum = Long.bitCount(firstNum);
            if(bitOfNum <= answer) {
                canMake = true;
                break;
            }
            answer++;
        }

        if(canMake)
            return answer;
        return -1;
    }
}