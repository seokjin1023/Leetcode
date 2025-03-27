//dp[0] -> dp[4]까지 영향을 미치는데 3번의 반복이 필요함.
//dp[i]는 i개를 골랐을 때 가장 높은 값
class Solution {
    public long maxScore(int[] a, int[] b) {
        int n = b.length;
        long[] dp = new long[5];
        Arrays.fill(dp, Long.MIN_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 4; j >= 1; j--) {
                if (dp[j - 1] != Long.MIN_VALUE) {
                    dp[j] = Math.max(dp[j], dp[j - 1] + (long)a[j - 1] * b[i]);
                }
            }
        }

        return dp[4];
    }
}