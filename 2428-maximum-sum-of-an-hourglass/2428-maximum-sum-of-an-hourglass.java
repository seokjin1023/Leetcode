class Solution {
    public int maxSum(int[][] grid) {
        int[][] columm3Sum = new int[grid.length][grid[0].length - 2];
        int[][] column1Sum = new int[grid.length - 2][grid[0].length - 2];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length - 2; j++) {
                if(i != 0 && i != grid.length - 1)
                    column1Sum[i - 1][j] = grid[i][j + 1];
                columm3Sum[i][j] = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < grid.length - 2; i++) {
            for(int j = 0; j < grid[0].length - 2; j++) {
                max = Math.max(max, columm3Sum[i][j] + column1Sum[i][j] + columm3Sum[i + 2][j]);
            }
        }
        return max;
    }
}