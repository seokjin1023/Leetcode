class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1)
            return -1;
        Queue<int[]> bfs = new LinkedList<>();
        bfs.add(new int[]{0, 0});
        grid[0][0] = 1;
        while(!bfs.isEmpty()) {
            int[] currentLocation = bfs.poll();
            int curX = currentLocation[0];
            int curY = currentLocation[1];
            int[][] direction = {{-1 , 1}, {0 , 1}, {1 , 1}, {-1 , 0}, {1 , 0}, {-1 , -1}, {0 , -1}, {1 , -1}};
            for(int i = 0; i < direction.length; i++) {
                int x = direction[i][0];
                int y = direction[i][1];
                if(curX + x >= 0 && curX + x < grid.length && curY + y >= 0 && curY + y < grid.length && grid[curX + x][curY + y] == 0) {
                    if(curX + x == grid.length - 1 && curY + y == grid.length - 1)
                        return grid[curX][curY] + 1;
                    grid[curX + x][curY + y] = grid[curX][curY] + 1;
                    bfs.add(new int[]{curX + x, curY + y});
                }
            }
        }
        return -1;
    }
}