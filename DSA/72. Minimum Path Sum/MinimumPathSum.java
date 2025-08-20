public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        // Test case 1
        int[][] grid1 = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        System.out.println("Minimum Path Sum for grid1: " + minPathSum(grid1)); // Output: 7

        // Test case 2
        int[][] grid2 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println("Minimum Path Sum for grid2: " + minPathSum(grid2)); // Output: 12

        // Test case 3
        int[][] grid3 = {
            {1, 2},
            {1, 1}
        };
        System.out.println("Minimum Path Sum for grid3: " + minPathSum(grid3)); // Output: 3

        // Test case 4
        int[][] grid4 = {
            {5, 3, 2},
            {1, 4, 1},
            {1, 1, 1}
        };
        System.out.println("Minimum Path Sum for grid4: " + minPathSum(grid4)); // Output: 8
    }
}
