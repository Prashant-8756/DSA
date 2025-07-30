import java.util.Arrays;

public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        
        int left = 0, right = tokens.length - 1;
        int score = 0, maxScore = 0;

        while (left <= right) {
            if (P >= tokens[left]) {
                P -= tokens[left]; 
                score++;           
                maxScore = Math.max(maxScore, score); 
                left++;           
            } else if (score > 0) { 
                P += tokens[right]; 
                score--;            
                right--;           
            } else {
                break; 
            }
        }

        return maxScore; 
    }

    public static void main(String[] args) {
        BagOfTokens bagOfTokens = new BagOfTokens();
        int[] tokens = {100, 200, 300, 400};
        int P = 200;
        System.out.println(bagOfTokens.bagOfTokensScore(tokens, P)); // Output: 2
    }
}
