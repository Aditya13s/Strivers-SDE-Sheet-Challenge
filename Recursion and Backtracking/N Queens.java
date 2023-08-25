/*
 * Brute Force
 * TC = O(N! * N)
 * SC = O(N^2)
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[][] chess = new int[n][n];
        List<List<String>> result = new ArrayList<>();
        getNQueens(0, chess, result);

        return result;
        
    }

    public void getNQueens(int row, int[][] chess, List<List<String>> result) {
        if(row == chess.length) {
            List<String> res = new LinkedList<>();
            for (int i = 0; i < chess.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int cell : chess[i]) {
                    sb.append(cell == 1 ? 'Q' : '.');
                }
                res.add(sb.toString());
            }

            result.add(new ArrayList<>(res));
            return;
        }

        for(int i=0; i<chess.length; i++) {
            if(isQueenSafe(chess, row, i)) {
                chess[row][i] = 1;
                getNQueens(row+1, chess, result);
                chess[row][i] = 0;
            }
        }
    }
    
    public boolean isQueenSafe(int[][] chess, int row, int col) {
        int tempRow = row;
        int tempCol = col;
        while(tempRow >= 0 && tempCol >= 0) {
            if(chess[tempRow--][tempCol--] == 1) return false;
        }

        tempRow = row;
        tempCol = col;
        while(tempRow >= 0 && tempCol < chess.length) {
            if(chess[tempRow--][tempCol++] == 1) return false;
        }

        tempRow = row;
        tempCol = col;
        while(tempRow >= 0) {
            if(chess[tempRow--][tempCol] == 1) return false;
        }

        return true;
    }
}

/*
 * Optimal
 * TC = O(N!)
 * SC = O(N)
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queenPositions = new int[n];
        solveNQueensHelper(0, queenPositions, result);
        return result;
    }

    public void solveNQueensHelper(int row, int[] queenPositions, List<List<String>> result) {
        int n = queenPositions.length;
        if (row == n) {
            List<String> soln = new ArrayList<>();
            for (int pos : queenPositions) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append(i == pos ? 'Q' : '.');
                }
                soln.add(sb.toString());
            }
            result.add(soln);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, queenPositions)) {
                queenPositions[row] = col;
                solveNQueensHelper(row + 1, queenPositions, result);
            }
        }
    }

    public boolean isSafe(int row, int col, int[] queenPositions) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = queenPositions[prevRow];
            if (prevCol == col || Math.abs(prevCol - col) == row - prevRow) {
                return false;
            }
        }
        return true;
    }
}