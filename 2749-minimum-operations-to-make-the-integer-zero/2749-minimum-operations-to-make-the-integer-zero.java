class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        if(num1 <= num2)
            return -1;

        int answer = Integer.MAX_VALUE;

        for(long i = 0; i <= 60; i++) {
            long target = (long)num1 - i * (long)num2;
            if(target <= 0) break;
            int operationNum = 0;
            long maxOperationNum = 0;
            while(target > 0) {
                if(operationNum > i) break;
                long highNum = Long.highestOneBit(target);
                target -= highNum;
                operationNum++;
                maxOperationNum += highNum;
            }
            if(operationNum <= i && maxOperationNum >= i)
                answer = Math.min(answer, (int)i);
        }
        if(answer == Integer.MAX_VALUE)
            return -1;
        return answer;
    }
}