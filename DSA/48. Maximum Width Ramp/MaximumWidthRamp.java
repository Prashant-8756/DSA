import java.util.Arrays;

public class MaximumWidthRamp {
    public int maxWidthRamp(int[] A) {
        int n = A.length;
        int maxWidth = 0;

        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = A[i];
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        int minIndex = pairs[0][1];

        for (int i = 0; i < n; i++) {
            minIndex = Math.min(minIndex, pairs[i][1]);
            maxWidth = Math.max(maxWidth, pairs[i][1] - minIndex);
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        MaximumWidthRamp solution = new MaximumWidthRamp();
        int[] A = {6, 0, 8, 2, 1, 5};
        System.out.println("Maximum Width Ramp: " + solution.maxWidthRamp(A)); // Output: 4
    }
}
