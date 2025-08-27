public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int gap = 1; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1]; 
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        
        String test1 = "bbbab";
        System.out.println("Longest Palindromic Subsequence of \"" + test1 + "\": " + lps.longestPalindromeSubseq(test1)); // Output: 4

        String test2 = "cbbd";
        System.out.println("Longest Palindromic Subsequence of \"" + test2 + "\": " + lps.longestPalindromeSubseq(test2)); // Output: 2

        String test3 = "a";
        System.out.println("Longest Palindromic Subsequence of \"" + test3 + "\": " + lps.longestPalindromeSubseq(test3)); // Output: 1

        String test4 = "ac";
        System.out.println("Longest Palindromic Subsequence of \"" + test4 + "\": " + lps.longestPalindromeSubseq(test4)); // Output: 1

        String test5 = "racecar";
        System.out.println("Longest Palindromic Subsequence of \"" + test5 + "\": " + lps.longestPalindromeSubseq(test5)); // Output: 7
    }
}
