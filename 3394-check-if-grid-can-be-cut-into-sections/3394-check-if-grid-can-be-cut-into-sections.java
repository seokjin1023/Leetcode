//가로와 세로에 같은 함수를 적용해서 찾을 수 있다.
//어떤 값에서 시작하는게 최대가 존재한다면 그 값을 적용한다.
//start되는 부분이 end보다 크다면 그 중간에 cut을 적용해도 괜찮다!
//만약 더 효율적으로 바꾸고 싶다면 rectangles를 그대로 getBoundNum에 사용하고 x나 y에 따른 parameter를 추가해서 사용.
class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] xPos = new int[rectangles.length][2];
        int[][] yPos = new int[rectangles.length][2];
        for (int i = 0; i < rectangles.length; i++) {
            xPos[i][0] = rectangles[i][0];
            xPos[i][1] = rectangles[i][2];
            yPos[i][0] = rectangles[i][1];
            yPos[i][1] = rectangles[i][3];
        }
        return getBoundNum(xPos) || getBoundNum(yPos);
    }
    private boolean getBoundNum(int[][] positions) {
        Arrays.sort(positions, Comparator.comparingInt(a -> a[0]));
        int boundCount = 0;
        int end = positions[0][1];
        for(int[] position : positions) {
            if(position[0] >= end) {
                boundCount++;
                end = position[1];
            }
            else {
                end = Math.max(end, position[1]);
            }
            if(boundCount >= 2) break;
        }
        return boundCount >= 2;
    }
}