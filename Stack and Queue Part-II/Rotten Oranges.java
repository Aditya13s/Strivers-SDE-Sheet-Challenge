/*
 * Using BFS
 * TC = O(M*N)
 * SC = O(M*N)
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int maxTime = 0;
        int m = grid.length, n = grid[0].length;
        int[][] visited = new int[m][n];
        int cntFresh = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new Pair(i,j,0));
                    visited[i][j] = 2;
                } else {
                    visited[i][j] = 0;
                }
                if(grid[i][j] == 1) cntFresh++;
            }
        }
        if(cntFresh == 0) return 0;
        int cnt = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!queue.isEmpty()) {
            int r = queue.peek().row;
            int c = queue.peek().col;
            int t = queue.peek().time;
            queue.poll();

            for(int i=0; i<4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    queue.add(new Pair(nrow, ncol, t+1));
                    visited[nrow][ncol] = 2;
                    cnt++;
                }
            }
            maxTime = Math.max(maxTime, t);
        }
        if(cnt != cntFresh) return -1;
        
        return maxTime;
    }

    class Pair {
        int row;
        int col;
        int time;

        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}