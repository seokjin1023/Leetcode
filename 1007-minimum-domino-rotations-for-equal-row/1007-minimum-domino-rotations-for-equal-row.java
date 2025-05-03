class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        boolean[] isCandidate = new boolean[6];
        Arrays.fill(isCandidate, true);
        int[] numOfTop = new int[6];
        int[] numOfBottom = new int[6];
        for(int i = 0; i < tops.length; i++) {
            numOfTop[tops[i] - 1]++;
            numOfBottom[bottoms[i] - 1]++;
            for(int j = 1; j <= 6; j++) {
                if(!(j == tops[i] || j == bottoms[i]))
                    isCandidate[j - 1] = false;
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < 6; i++) {
            if(isCandidate[i]) {
                int minNum = Math.min(tops.length - numOfTop[i], bottoms.length - numOfBottom[i]);
                answer = Math.min(minNum, answer);
            }
        }
        if(answer == Integer.MAX_VALUE)
            return -1;
        return answer;
    }
}