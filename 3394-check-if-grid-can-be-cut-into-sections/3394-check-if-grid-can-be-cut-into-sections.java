//가로와 세로에 같은 함수를 적용해서 찾을 수 있다.
//어떤 값에서 시작하는게 최대가 존재한다면 그 값을 적용한다.
//start되는 부분이 end보다 크다면 그 중간에 cut을 적용해도 괜찮다!
class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> xList = getPosition(true, rectangles);
        List<int[]> yList = getPosition(false, rectangles);
        if(getBoundNum(xList) >= 2 || getBoundNum(yList) >= 2)
            return true;
        return false;
    }
    private List<int[]> getPosition(boolean isX, int[][]rectangles) {
        List<int[]> list = new ArrayList<>();
        int start = 1, end = 3;
        if(isX) {
            start = 0;
            end = 2;
        }
        for(int[] rectangle : rectangles)
            list.add(new int[]{rectangle[start], rectangle[end]});

        list.sort(Comparator.comparingInt(a -> a[0]));
        return list;
    }
    private int getBoundNum(List<int[]> positions) {
        int boundCount = 0;
        int end = positions.get(0)[1];
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
        return boundCount;
    }
}