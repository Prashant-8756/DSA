public class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j-1] + s2.charAt(j-1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(
                        dp[i-1][j] + s1.charAt(i-1),
                        dp[i][j-1] + s2.charAt(j-1)
                    );
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "sea";
        String s2 = "eat";
        System.out.println("Minimum ASCII Delete Sum for 'sea' and 'eat': " + sol.minimumDeleteSum(s1, s2));
        // Expected output: 231

        s1 = "delete";
        s2 = "leet";
        System.out.println("Minimum ASCII Delete Sum for 'delete' and 'leet': " + sol.minimumDeleteSum(s1, s2));
        // Expected output: 403

        s1 = "abc";
        s2 = "abc";
        System.out.println("Minimum ASCII Delete Sum for 'abc' and 'abc': " + sol.minimumDeleteSum(s1, s2));
        // Expected output: 0 (strings are already equal)
    }
}
