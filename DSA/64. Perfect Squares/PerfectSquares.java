import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Base case: 0 can be represented by 0 perfect squares

        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            for (int j = square; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - square] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();
        
        System.out.println(ps.numSquares(12)); // Output: 3 (4 + 4 + 4)
        System.out.println(ps.numSquares(13)); // Output: 2 (4 + 9)
        System.out.println(ps.numSquares(1));  // Output: 1 (1)
        System.out.println(ps.numSquares(2));  // Output: 2 (1 + 1)
        System.out.println(ps.numSquares(3));  // Output: 3 (1 + 1 + 1)
        System.out.println(ps.numSquares(16)); // Output: 1 (16)
    }
}
