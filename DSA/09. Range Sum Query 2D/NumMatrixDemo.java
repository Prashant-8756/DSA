public class NumMatrixDemo {

    static class NumMatrix {
        private int[][] prefixSum;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                prefixSum = new int[0][0];
                return;
            }
            
            int rows = matrix.length;
            int cols = matrix[0].length;
            prefixSum = new int[rows + 1][cols + 1];

            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    prefixSum[i][j] = matrix[i - 1][j - 1] 
                                     + prefixSum[i - 1][j] 
                                     + prefixSum[i][j - 1] 
                                     - prefixSum[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return prefixSum[row2 + 1][col2 + 1] 
                 - prefixSum[row1][col2 + 1] 
                 - prefixSum[row2 + 1][col1] 
                 + prefixSum[row1][col1];
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println("Sum of region (1,1) to (2,2): " + numMatrix.sumRegion(1, 1, 2, 2)); // 28
        System.out.println("Sum of region (0,0) to (1,1): " + numMatrix.sumRegion(0, 0, 1, 1)); // 11
        System.out.println("Sum of region (0,0) to (2,2): " + numMatrix.sumRegion(0, 0, 2, 2)); // 45
    }
}

