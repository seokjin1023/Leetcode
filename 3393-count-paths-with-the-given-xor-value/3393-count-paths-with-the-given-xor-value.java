class Solution {
    public int countPathsWithXorValue(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        if(m == 1 && n == 1) {
            if(grid[0][0] == k)
                return 1;
            return 0;
        }
        int answer = 0;
        int[][][] xorGrid = new int[m][n][16];
        int[][] directions = {{-1, 0}, {0, -1}};
        xorGrid[0][0][grid[0][0]] = 1;
         for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue; // (0,0)에서 이미 초기화했으므로 패스
                
                int num = grid[i][j];

                for (int[] direction : directions) {
                    int x = i + direction[0], y = j + direction[1];
                    if (x >= 0 && y >= 0) {
                        for (int a = 0; a < 16; a++) {
                            if (xorGrid[x][y][a] > 0) {
                                int xorValue = a ^ num;
                                xorGrid[i][j][xorValue] = (xorGrid[i][j][xorValue] + xorGrid[x][y][a]) % 1000000007;
                            }
                        }
                    }
                }
            }
        }
        return xorGrid[m - 1][n - 1][k];
    }
}