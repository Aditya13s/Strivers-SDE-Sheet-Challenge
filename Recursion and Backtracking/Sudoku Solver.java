/*
 * TC = O(9^(N*N))
 * SC = O(1)
 */
class Solution {
    public void solveSudoku(char[][] board) {
        solveBoard(board);
    }

    public boolean solveBoard(char[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                if(board[i][j] == '.') {
                    for(char c='1'; c<='9'; c++) {
                        if(isValid(i, j, board, c)) {
                            board[i][j] = c;
                            if(solveBoard(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(int row, int col, char[][] board, char c) {
        for(int i = 0; i< board.length; i++) {
            if(board[row][i] == c || board[i][col] == c || board[3*(row/3) + i/3][3*(col/3) + i%3] == c) return false; 
        }
        return true; 
    }
}