class Solution {
    public int orangesRotting(int[][] grid) {
        int countFresh = 0;
        Queue<int[]> RottenLocation = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) 
                    countFresh++;
                else if(grid[i][j] == 2)
                    RottenLocation.add(new int[]{i, j, 0});
            }
        }
        if(countFresh == 0)
            return 0;
        int answer = 0;
        while(!RottenLocation.isEmpty()) {
            int[] currentRotten = RottenLocation.poll();
            answer = currentRotten[2];
            int minute = currentRotten[2] + 1;
            int[][] direction = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
            for(int i = 0; i < 4; i++) {
                int currentX = currentRotten[0];
                int currentY = currentRotten[1];
                int moveX = direction[i][0];
                int moveY = direction[i][1];
                if(currentX + moveX >= 0 && currentX + moveX < grid.length && currentY + moveY >= 0 && currentY + moveY < grid[0].length) {
                    if(grid[currentX + moveX][currentY + moveY] == 1) {
                        grid[currentX + moveX][currentY + moveY] = 2;
                        RottenLocation.add(new int[]{currentX + moveX, currentY + moveY, minute});
                        countFresh--;
                    }
                }
            }
        }
        if(countFresh > 0)
            return -1;
        return answer;

    }
}