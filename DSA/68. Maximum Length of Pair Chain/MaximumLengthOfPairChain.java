import java.util.Arrays;

public class MaximumLengthOfPairChain {

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int currentEnd = Integer.MIN_VALUE;

        for (int[] pair : pairs) {
            if (pair[0] > currentEnd) {
                count++;
                currentEnd = pair[1]; // Update the end of the current chain
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] pairs1 = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println("Maximum Length of Pair Chain (Test 1): " + findLongestChain(pairs1)); // Output: 2

        int[][] pairs2 = {{5, 24}, {39, 60}, {15, 25}, {27, 40}, {50, 90}};
        System.out.println("Maximum Length of Pair Chain (Test 2): " + findLongestChain(pairs2)); // Output: 3

        int[][] pairs3 = {{1, 2}, {3, 4}, {5, 6}};
        System.out.println("Maximum Length of Pair Chain (Test 3): " + findLongestChain(pairs3)); // Output: 3

        int[][] pairs4 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println("Maximum Length of Pair Chain (Test 4): " + findLongestChain(pairs4)); // Output: 2
    }
}
