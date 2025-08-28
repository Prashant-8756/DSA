public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();

        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        PalindromicSubstrings solution = new PalindromicSubstrings();

        String test1 = "abc";
        System.out.println("Input: " + test1);
        System.out.println("Number of palindromic substrings: " + solution.countSubstrings(test1));
        // Expected output: 3 ("a", "b", "c")

        String test2 = "aaa";
        System.out.println("Input: " + test2);
        System.out.println("Number of palindromic substrings: " + solution.countSubstrings(test2));
        // Expected output: 6 ("a", "a", "a", "aa", "aa", "aaa")

        String test3 = "racecar";
        System.out.println("Input: " + test3);
        System.out.println("Number of palindromic substrings: " + solution.countSubstrings(test3));
        // Expected output: 10 ("r", "a", "c", "e", "c", "a", "r", "cec", "aceca", "racecar")
    }
}
