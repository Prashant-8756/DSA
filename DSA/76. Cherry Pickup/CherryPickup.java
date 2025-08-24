import java.util.Arrays;

public class CherryPickup {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        dp[0][0][0] = grid[0][0];

        for (int r = 0; r < n; r++) {
            for (int c1 = 0; c1 < m; c1++) {
                for (int c2 = 0; c2 < m; c2++) {
                    if (dp[r][c1][c2] < 0) continue;
                    if (c1 < m - 1) dp[r][c1 + 1][c2] = Math.max(dp[r][c1 + 1][c2], dp[r][c1][c2] + grid[r][c1 + 1]);
                    if (c2 < m - 1) dp[r][c1][c2 + 1] = Math.max(dp[r][c1][c2 + 1], dp[r][c1][c2] + grid[r][c2 + 1]);
                    if (c1 < m - 1 && c2 < m - 1) dp[r][c1 + 1][c2 + 1] = Math.max(dp[r][c1 + 1][c2 + 1], dp[r][c1][c2] + grid[r][c1 + 1] + grid[r][c2 + 1]);
                }
            }
            if (r + 1 < n) {
                for (int c1 = 0; c1 < m; c1++) {
                    for (int c2 = 0; c2 < m; c2++) {
                        if (dp[r][c1][c2] < 0) continue;
                        dp[r + 1][c1][c2] = Math.max(dp[r + 1][c1][c2], dp[r][c1][c2] + grid[r + 1][c1]);
                    }
                }
            }
        }

        return Math.max(0, dp[n - 1][m - 1][m - 1]);
    }

    public static void main(String[] args) {
        CherryPickup cp = new CherryPickup();
        int[][] grid = {
            {0, 1, -1},
            {1, 0, -1},
            {1, 1, 1}
        };
        System.out.println("Maximum cherries collected: " + cp.cherryPickup(grid)); // Output: 5

        int[][] grid2 = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        System.out.println("Maximum cherries collected: " + cp.cherryPickup(grid2)); // Output: 9
    }
}
