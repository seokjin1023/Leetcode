class Solution {
    public int numSub(String s) {
        //(n)(n + 1) / 2
        long answer = 0L;
        long seqLength = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                seqLength++;
            }
            else {
                if(seqLength != 0) {
                    answer += seqLength * (seqLength + 1) / 2;
                    seqLength = 0;
                    answer %= 1000000007;
                }
            }
        }
        if(seqLength != 0) 
            answer += seqLength * (seqLength + 1) / 2;
        answer %= 1000000007;
        return (int)answer;
    }
}