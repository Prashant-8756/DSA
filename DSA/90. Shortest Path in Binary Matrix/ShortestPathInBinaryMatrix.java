import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    private static final int[][] DIRECTIONS = {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1},           {0, 1},
        {1, -1},  {1, 0},  {1, 1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        int pathLength = 1; // start cell counts as length 1

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0], c = cell[1];

                if (r == n - 1 && c == n - 1) return pathLength;

                for (int[] dir : DIRECTIONS) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n &&
                        !visited[nr][nc] && grid[nr][nc] == 0) {
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            pathLength++;
        }

        return -1; // no path found
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix solver = new ShortestPathInBinaryMatrix();

        int[][] grid1 = {
            {0, 1},
            {1, 0}
        };
        System.out.println("Test case 1 output: " + solver.shortestPathBinaryMatrix(grid1)); // Expected: 2

        int[][] grid2 = {
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 0}
        };
        System.out.println("Test case 2 output: " + solver.shortestPathBinaryMatrix(grid2)); // Expected: 4

        int[][] grid3 = {
            {1, 0, 0},
            {1, 1, 0},
            {1, 1, 0}
        };
        System.out.println("Test case 3 output: " + solver.shortestPathBinaryMatrix(grid3)); // Expected: -1

        int[][] grid4 = {
            {0}
        };
        System.out.println("Test case 4 output: " + solver.shortestPathBinaryMatrix(grid4)); // Expected: 1
    }
}
