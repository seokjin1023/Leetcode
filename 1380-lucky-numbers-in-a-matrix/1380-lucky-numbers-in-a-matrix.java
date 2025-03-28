class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            int min = 0;
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][min] > matrix[i][j]) min = j;
            }
            int minValue = matrix[i][min];
            int maxRow = 0;
            for(int j = 0; j < matrix.length; j++) {
                if(matrix[j][min] > matrix[maxRow][min]) maxRow = j;
            }
            if(maxRow == i) answer.add(minValue);
        }
        return answer;
    }
}