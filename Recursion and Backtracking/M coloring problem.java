/*
 * TC = O(N^M)
 * SC = O(N)
 */
class solve {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] color = new int[n];

        return graphColoringHelper(graph, m, color, 0, n);
    }

    public boolean graphColoringHelper(boolean graph[][], int m, int[] color, int v, int n) {
        if (v == n) {
            return true;
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(graph, color, v, c, n)) {
                color[v] = c;

                if (graphColoringHelper(graph, m, color, v + 1, n))
                    return true;

                color[v] = 0;
            }
        }

        return false;
    }

    public boolean isSafe(boolean graph[][], int[] color, int v, int c, int n) {
        for (int i = 0; i < n; i++) {
            if (graph[v][i] && color[i] == c)
                return false;
        }
        return true;
    }
}