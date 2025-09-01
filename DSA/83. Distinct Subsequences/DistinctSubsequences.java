public class DistinctSubsequences {
    public static int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "rabbbit", t1 = "rabbit";
        System.out.println("Test case 1:");
        System.out.println("s = " + s1 + ", t = " + t1);
        System.out.println("Number of distinct subsequences: " + numDistinct(s1, t1));
        // output: 3

        String s2 = "babgbag", t2 = "bag";
        System.out.println("\nTest case 2:");
        System.out.println("s = " + s2 + ", t = " + t2);
        System.out.println("Number of distinct subsequences: " + numDistinct(s2, t2));
        //  output: 5

        String s3 = "abcdef", t3 = "ace";
        System.out.println("\nTest case 3:");
        System.out.println("s = " + s3 + ", t = " + t3);
        System.out.println("Number of distinct subsequences: " + numDistinct(s3, t3));
        //  output: 1
    }
}
