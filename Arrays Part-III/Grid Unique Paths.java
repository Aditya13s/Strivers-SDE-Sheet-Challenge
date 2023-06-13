/*
 * Brute Force(Recursion)
 * TC = O(2^(m+n))
 * SC = O()
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int paths = getPaths(0,0,m-1, n-1);
        return paths;
    }
    public int getPaths(int r, int c, int m, int n) {
        if(r == m && c == n) return 1;
        if(r>m || c > n) return 0;
        else return getPaths(r, c+1, m, n) + getPaths(r+1, c, m, n);
    }
}


/*
 * Better(Dynamic Programming)
 * TC = O(n*m)
 * SC = O(n*m)
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        int paths = getPaths(0,0,m-1, n-1, dp);
        return paths;
    }
    public int getPaths(int r, int c, int m, int n, int dp[][]) {
        if(r == m && c == n) return 1;
        if(r>m || c > n) return 0;

        if(dp[r][c] != -1) return dp[r][c]; 
        else return dp[r][c] = getPaths(r, c+1, m, n, dp) + getPaths(r+1, c, m, n, dp);
    }
}

/*
 * Optimal(Combinatorics)
 * TC = O(n) or O(m)
 * SC = O(1)
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int N = m+n-2;
        int r= m-1;
        double res = 1;

        for(int i=1; i<=r; i++) {
            res = res *(N-r+i)/i;
        }
        return (int)res;
    }
    
}