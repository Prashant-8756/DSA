import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    private static final int[][] DIRECTIONS = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;

        int minutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottenThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0], c = curr[1];

                for (int[] dir : DIRECTIONS) {
                    int nr = r + dir[0], nc = c + dir[1];

                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // rot the fresh orange
                        freshCount--;
                        queue.offer(new int[]{nr, nc});
                        rottenThisMinute = true;
                    }
                }
            }

            if (rottenThisMinute) minutes++;
        }

        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        RottenOranges solution = new RottenOranges();

        int[][] grid1 = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        System.out.println(solution.orangesRotting(grid1)); // Expected: 4

        int[][] grid2 = {
            {2,1,1},
            {0,1,1},
            {1,0,1}
        };
        System.out.println(solution.orangesRotting(grid2)); // Expected: -1 (some fresh oranges can't rot)

        int[][] grid3 = {
            {0,2}
        };
        System.out.println(solution.orangesRotting(grid3)); // Expected: 0 (no fresh oranges)
    }
}
