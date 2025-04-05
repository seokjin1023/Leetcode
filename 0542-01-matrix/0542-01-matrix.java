class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] distance = new int[mat.length][mat[0].length];
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0) 
                    que.add(new int[]{i, j, 0});
                else
                    distance[i][j] = -1;
            }
        }
        while(!que.isEmpty()) {
            int[] location = que.poll();
            int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for(int i = 0; i < direction.length; i++) {
                int x = location[0] + direction[i][0];
                int y = location[1] + direction[i][1];
                if(x >= 0 && x < mat.length && y >= 0 && y < mat[0].length && distance[x][y] == -1) {
                    distance[x][y] = location[2] + 1;
                    que.add(new int[]{x, y, location[2] + 1});
                }
            }
        }
        return distance;
    }
}