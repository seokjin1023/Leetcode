class Solution {
    private final int mod = 1000000007;
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][][] product = new long[m][n][2];
        product[0][0][0] = (long)grid[0][0];
        product[0][0][1] = (long)grid[0][0];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j > 0) {
                    product[i][j][0] = (long)product[i][j - 1][0] * grid[i][j];
                    product[i][j][1] = (long)product[i][j - 1][1] * grid[i][j];
                }
                if(i > 0) {
                    if(j == 0) {
                        product[i][j][0] = (long)product[i - 1][j][0] * grid[i][j];
                        product[i][j][1] = (long)product[i - 1][j][1] * grid[i][j];
                    }
                    else {
                        long[] value = new long[4];
                        value[0] = product[i][j - 1][0] * grid[i][j];
                        value[1] = product[i][j - 1][1] * grid[i][j];
                        value[2] = product[i - 1][j][0] * grid[i][j];
                        value[3] = product[i - 1][j][1] * grid[i][j];
                        product[i][j][0] = Arrays.stream(value).min().getAsLong();
                        product[i][j][1] = Arrays.stream(value).max().getAsLong();
                    }
                }
            }
        }
        if(product[m - 1][n - 1][1] < 0) return -1;
        
        return (int)(product[m - 1][n - 1][1] % mod);
    }
}