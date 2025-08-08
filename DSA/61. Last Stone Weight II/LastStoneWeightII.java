import java.util.Arrays;

public class LastStoneWeightII {
    public static void main(String[] args) {
        int[] stones1 = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeightII(stones1)); // Output: 1

        int[] stones2 = {31, 26, 33, 21, 40};
        System.out.println(lastStoneWeightII(stones2)); // Output: 5

        int[] stones3 = {1, 2};
        System.out.println(lastStoneWeightII(stones3)); // Output: 1
    }

    public static int lastStoneWeightII(int[] stones) {
        int totalWeight = Arrays.stream(stones).sum();
        int n = stones.length;
        int target = totalWeight / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = dp[j] || dp[j - stone];
            }
        }

        for (int j = target; j >= 0; j--) {
            if (dp[j]) {
                return totalWeight - 2 * j; 
            }
        }

        return totalWeight; 
    }
}
