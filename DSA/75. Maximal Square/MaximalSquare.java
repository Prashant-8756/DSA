public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int maxSide = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;// Return the area of the largest square
    }

    public static void main(String[] args) {
        MaximalSquare ms = new MaximalSquare();

        char[][] matrix1 = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        System.out.println("Maximal Square Area: " + ms.maximalSquare(matrix1)); // Output: 4

        char[][] matrix2 = {
            {'0', '1'},
            {'1', '0'}
        };
        System.out.println("Maximal Square Area: " + ms.maximalSquare(matrix2)); // Output: 1

        char[][] matrix3 = {
            {'0'}
        };
        System.out.println("Maximal Square Area: " + ms.maximalSquare(matrix3)); // Output: 0

        char[][] matrix4 = {
            {'1', '1'},
            {'1', '1'}
        };
        System.out.println("Maximal Square Area: " + ms.maximalSquare(matrix4)); // Output: 4
    }
}
