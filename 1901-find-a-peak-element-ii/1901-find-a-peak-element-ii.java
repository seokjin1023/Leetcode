class Solution {
    public int[] findPeakGrid(int[][] mat) {
        //m x n 이라고 할 때 n/2열에서 가장 큰 값 찾기 => (i, j)
        //(i, j - 1) 과 (i, j + 1)과 비교해서 1차원에서 구할 때와 같은 방식
        int halfj = mat[0].length / 2;
        int rowIndex = 0;
        for(int i = 1; i < mat.length; i++) {
            if(mat[i][halfj] > mat[rowIndex][halfj])
                rowIndex = i;
        }
        int startRow = 0, endRow = mat.length;
        int startCol = 0, endCol = mat[0].length;
        while(true) {
            boolean leftBig = (halfj - 1 >= 0) && (mat[rowIndex][halfj] < mat[rowIndex][halfj - 1]);
            boolean rightBig = (halfj + 1 < mat[0].length) && (mat[rowIndex][halfj] < mat[rowIndex][halfj + 1]);
            boolean upBig = (rowIndex - 1 >= 0) && (mat[rowIndex][halfj] < mat[rowIndex - 1][halfj]);
            boolean downBig = (rowIndex + 1 < mat.length) && (mat[rowIndex][halfj] < mat[rowIndex + 1][halfj]);
            if(leftBig && rightBig) {
                if(mat[rowIndex][halfj - 1] > mat[rowIndex][halfj + 1]) {
                    endCol = halfj;
                    halfj = (startCol + halfj) / 2;
                }
                else {
                    startCol = halfj;
                    halfj = (halfj + endCol) / 2;
                }
            }
            else if(leftBig) {
                endCol = halfj;
                halfj = (startCol + halfj) / 2;
            }
            else if(rightBig) {
                startCol = halfj;
                halfj = (halfj + endCol) / 2;
            }
            else if(upBig && downBig) {
                if(mat[rowIndex - 1][halfj] > mat[rowIndex + 1][halfj]) {
                    endRow = rowIndex; 
                    rowIndex = (startRow + rowIndex) / 2;
                }
                else {
                    startRow = rowIndex;
                    rowIndex = (rowIndex + endRow) / 2;
                }
            }
            else if(upBig) {
                endRow = rowIndex; 
                rowIndex = (startRow + rowIndex) / 2;
            }
            else if(downBig) {
                startRow = rowIndex;
                rowIndex = (rowIndex + endRow) / 2;
            }
            else {
                return new int[]{rowIndex, halfj};
            }
        }

    }
}