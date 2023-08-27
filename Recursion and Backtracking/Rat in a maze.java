/*
 * TC = O(3^(N^2))
 * SC = O(N^2)
 */
public class Solution {
    public static List<String> ratMaze(int[][] mat) {
        List<String> result = new ArrayList<>();
        ratMazeHelper(mat, 0, 0, "", result, new boolean[mat.length][mat.length]);
        return result;
    }

    public static void ratMazeHelper(int[][] mat, int row, int col, String path, List<String> paths, boolean[][] visited) {
        if (row >= mat.length || col >= mat.length || row < 0 || col < 0 || mat[row][col] == 0 || visited[row][col]) {
            return;
        }
        if (row == mat.length - 1 && col == mat.length - 1) {
            paths.add(path);
            return;
        }

        visited[row][col] = true;
        ratMazeHelper(mat, row - 1, col, path + "U", paths, visited);
        ratMazeHelper(mat, row + 1, col, path + "D", paths, visited);
        ratMazeHelper(mat, row, col - 1, path + "L", paths, visited);
        ratMazeHelper(mat, row, col + 1, path + "R", paths, visited);

        visited[row][col] = false;

    }
}