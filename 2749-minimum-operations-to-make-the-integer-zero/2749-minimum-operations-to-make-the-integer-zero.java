/*
각각의 bit는 2의 거듭제곱
num2를 계속 빼나가면서 뺀 개수보다 bit가 1인 개수가 적다면 무조건 0으로 만들 수 있음.
*/
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
