class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        long answer = 0;
        for(int i = 0; i < questions.length; i++) {
            if(i > 0) dp[i] = Math.max(dp[i - 1], dp[i]);
            int canSolve = i + questions[i][1] + 1;
            if(canSolve < questions.length)
                dp[canSolve] = Math.max(dp[canSolve], dp[i] + questions[i][0]);
            else {
                answer = Math.max(answer, dp[i] + questions[i][0]);
            } 
        }
        return answer;
    }
}