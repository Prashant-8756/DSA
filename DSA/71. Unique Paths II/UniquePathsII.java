public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 1; // Starting point

        for (int i = 1; i < m; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 0) ? dp[i - 1][0] : 0;
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = (obstacleGrid[0][j] == 0) ? dp[0][j - 1] : 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0; // Blocked cell
                }
            }
        }

        return dp[m - 1][n - 1]; 
    }

    public static void main(String[] args) {
        UniquePathsII solution = new UniquePathsII();
        
        // Test case
        int[][] obstacleGrid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        
        int result = solution.uniquePathsWithObstacles(obstacleGrid);
        System.out.println("Number of unique paths: " + result); // Output: 2
    }
}
