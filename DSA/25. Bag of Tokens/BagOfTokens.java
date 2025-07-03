import java.util.Arrays;

public class BagOfTokens {

    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int maxScore = 0;
        int left = 0;
        int right = tokens.length - 1;

        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                score++;
                left++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) {
                power += tokens[right];
                score--;
                right--;
            } else {
                break;  // No moves left
            }
        }
        return maxScore;
    }

    public static void main(String[] args) {
        int[] tokens1 = {100, 200, 300, 400};
        int power1 = 200;
        System.out.println("Test Case 1:");
        System.out.println("Tokens: " + Arrays.toString(tokens1));
        System.out.println("Power: " + power1);
        System.out.println("Max Score: " + bagOfTokensScore(tokens1, power1));
        System.out.println("Expected: 2");
        System.out.println();

        int[] tokens2 = {100};
        int power2 = 50;
        System.out.println("Test Case 2:");
        System.out.println("Tokens: " + Arrays.toString(tokens2));
        System.out.println("Power: " + power2);
        System.out.println("Max Score: " + bagOfTokensScore(tokens2, power2));
        System.out.println("Expected: 0");
        System.out.println();

        int[] tokens3 = {71, 55, 82};
        int power3 = 54;
        System.out.println("Test Case 3:");
        System.out.println("Tokens: " + Arrays.toString(tokens3));
        System.out.println("Power: " + power3);
        System.out.println("Max Score: " + bagOfTokensScore(tokens3, power3));
        System.out.println("Expected: 1");
    }
}
