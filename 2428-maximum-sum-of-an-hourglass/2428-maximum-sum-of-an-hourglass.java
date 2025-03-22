class Solution {
    public int maxSum(int[][] grid) {
        int[][] columnSum = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            columnSum[i][0] = grid[i][0];
            for(int j = 1; j < grid[0].length; j++) {
                columnSum[i][j] = columnSum[i][j - 1] + grid[i][j];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < grid.length - 2; i++) {
            for(int j = 2; j < grid[0].length; j++) {
                if(j == 2)
                    max = Math.max(max, columnSum[i][j] + grid[i + 1][j - 1] + columnSum[i + 2][j]);
                else
                    max = Math.max(max, columnSum[i][j] - columnSum[i][j - 3] + grid[i + 1][j - 1] + columnSum[i + 2][j] - columnSum[i + 2][j - 3]);
            }
        }
        return max;
    }
}