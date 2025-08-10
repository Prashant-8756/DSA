import java.util.Arrays;

public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; 

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount]; 
    }

    public static void main(String[] args) {
        CoinChangeII solution = new CoinChangeII();
        
        int amount = 5;
        int[] coins = {1, 2, 5};
        int result = solution.change(amount, coins);
        
        System.out.println("Number of ways to make amount " + amount + " is: " + result);
    }
}
