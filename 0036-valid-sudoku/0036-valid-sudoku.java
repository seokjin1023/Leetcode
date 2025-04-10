class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(!rowSet.add(board[i][j])) return false;
                }
                if(board[j][i] != '.') {
                    if(!colSet.add(board[j][i])) return false;
                }
            }
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                Set<Character> boxSet = new HashSet<>();
                for(int row = 0; row < 3; row++) {
                    for(int col = 0; col < 3; col++) {
                        if(board[i * 3 + row][j * 3 + col] != '.')
                            if(!boxSet.add(board[i * 3 + row][j * 3 + col])) return false;
                    }
                }
            }
        }
        return true;
    }
}