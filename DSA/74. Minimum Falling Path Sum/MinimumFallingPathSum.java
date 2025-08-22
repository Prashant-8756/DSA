import java.util.Arrays;

public class MinimumFallingPathSum {
    
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] dp = new int[n][m];
        
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int minAbove = dp[i - 1][j]; // directly above
                if (j > 0) {
                    minAbove = Math.min(minAbove, dp[i - 1][j - 1]); // top-left diagonal
                }
                if (j < m - 1) {
                    minAbove = Math.min(minAbove, dp[i - 1][j + 1]); // top-right diagonal
                }
                dp[i][j] = matrix[i][j] + minAbove;
            }
        }
        
        int minPathSum = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minPathSum = Math.min(minPathSum, dp[n - 1][j]);
        }
        
        return minPathSum;
    }

    public static void main(String[] args) {
        MinimumFallingPathSum solution = new MinimumFallingPathSum();
        
        int[][] matrix1 = {
            {2, 1, 3},
            {6, 5, 4},
            {7, 8, 9}
        };
        System.out.println("Minimum Falling Path Sum (Test Case 1): " + solution.minFallingPathSum(matrix1)); // Output: 13
        
        int[][] matrix2 = {
            {-19, 57},
            {-40, -5}
        };
        System.out.println("Minimum Falling Path Sum (Test Case 2): " + solution.minFallingPathSum(matrix2)); // Output: -59
        
        int[][] matrix3 = {
            {1}
        };
        System.out.println("Minimum Falling Path Sum (Test Case 3): " + solution.minFallingPathSum(matrix3)); // Output: 1
        
        int[][] matrix4 = {
            {100, 200, 300},
            {400, 500, 600},
            {700, 800, 900}
        };
        System.out.println("Minimum Falling Path Sum (Test Case 4): " + solution.minFallingPathSum(matrix4)); // Output: 1200
    }
}
