import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0; 

        for (int coin : coins) {
            for (int x = coin; x <= amount; x++) {
                dp[x] = Math.min(dp[x], dp[x - coin] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Minimum coins for amount " + amount1 + ": " + coinChange(coins1, amount1)); // Output: 3

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Minimum coins for amount " + amount2 + ": " + coinChange(coins2, amount2)); // Output: -1

        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("Minimum coins for amount " + amount3 + ": " + coinChange(coins3, amount3)); // Output: 0

        int[] coins4 = {1, 5, 10, 25};
        int amount4 = 30;
        System.out.println("Minimum coins for amount " + amount4 + ": " + coinChange(coins4, amount4)); // Output: 2
    }
}
