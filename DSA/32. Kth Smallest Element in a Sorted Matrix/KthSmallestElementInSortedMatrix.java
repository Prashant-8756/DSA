public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countLessEqual(matrix, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int countLessEqual(int[][] matrix, int mid) {
        int count = 0;
        int n = matrix.length;
        int row = n - 1, col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                count += (row + 1); 
                col++; 
            } else {
                row--; 
            }
        }
        return count;
    }

    public static void main(String[] args) {
        KthSmallestElementInSortedMatrix solution = new KthSmallestElementInSortedMatrix();
        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        int k = 8;
        System.out.println("The " + k + "th smallest element is: " + solution.kthSmallest(matrix, k));
    }
}
