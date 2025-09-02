public class ShortestCommonSupersequence {

    public static String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            char c1 = str1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = str2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            char c1 = str1.charAt(i - 1);
            char c2 = str2.charAt(j - 1);

            if (c1 == c2) {
                sb.append(c1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(c1);
                i--;
            } else {
                sb.append(c2);
                j--;
            }
        }

        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "abac";
        String str2 = "cab";

        String scs = shortestCommonSupersequence(str1, str2);
        System.out.println("Shortest Common Supersequence: " + scs);
    }
}
