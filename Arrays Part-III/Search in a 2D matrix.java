/*
 * Brute Force(Nesting)
 * TC = O(M*N)
 * SC = O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}

/*
 * Better
 * TC = O(M+N)
 * SC = O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        while(r <= matrix.length-2 && matrix[r][matrix[0].length-1] < target) {
            r++;
        }       
        for(int i=0; i<matrix[0].length; i++) {
            if(matrix[r][i] == target) {
                return true;
            }
        }
        return false;
    }
    
}

/*
 * Optimal
 * TC = O(log(M+N))
 * SC = O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int lo = 0;
        int hi = (n*m) -1;

        while(hi >= lo) {
            int mid = (hi+lo)/2;
            if(matrix[mid/m][mid % m] > target) {
                hi = mid-1;
            } else if(matrix[mid/m][mid%m] < target) {
                lo = mid+1;
            } else {
                return true;
            }
        }
        return false;
    }
    
}