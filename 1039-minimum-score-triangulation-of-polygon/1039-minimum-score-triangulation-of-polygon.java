//레전드 괴랄한 2D dp 문제
//Main-Idea: dp[i][j]= min(dp[i][k]+dp[k][j]+A[i]×A[k]×A[j])
/*
가장 작은 삼각형부터 변의 개수를 늘려가면서 dp의 n각형 미만의 최적해를 보장해줌.
dp[i][j]에서 그 중 어떤 k를 찾는 것이 더 최적인지 확인하고 값을 구해야하기 때문에 Math.min 사용
*/
class Solution {
    public int minScoreTriangulation(int[] values) {
        int[][] dp = new int[values.length][values.length];
        for(int length = 2; length < values.length; length++) { //다각형의 크기
            for(int i = 0; i < values.length - length; i++) {
                int j = i + length;
                dp[i][j] = Integer.MAX_VALUE;
                
                for(int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[k] * values[j]);
                }
            }
        }
        return dp[0][values.length - 1];
    }
}