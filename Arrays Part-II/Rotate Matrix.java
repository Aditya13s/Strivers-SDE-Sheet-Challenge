/*
 * Brute Force
 * TC = O(N^2)
 * SC = O(N^2) 
 */
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] ans = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                ans[i][j] = matrix[i][j];
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = ans[n-1-j][i];
            }
        }
    }
}
/*
 * Optimal
 * TC = O(N^2)
 * SC = O(1) 
 */
class Solution {
    public void rotate(int[][] matrix) {
        
        transpose(matrix);
        reverse(matrix);
    }
    public void transpose(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=i; j<matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public void reverse(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix.length/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}