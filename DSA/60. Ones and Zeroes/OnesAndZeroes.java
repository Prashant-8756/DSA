import java.util.List;

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int zeros = 0, ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        OnesAndZeroes solution = new OnesAndZeroes();
        
        // Test case
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5; // Number of 0's
        int n = 3; // Number of 1's
        
        int result = solution.findMaxForm(strs, m, n);
        System.out.println("Maximum number of strings that can be formed: " + result);
    }
}
