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
