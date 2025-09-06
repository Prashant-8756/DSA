public class BuyAndSellStocksIV {

    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            buy[i] = Integer.MIN_VALUE;
        }

        for (int price : prices) {
            for (int t = 1; t <= k; t++) {
                buy[t] = Math.max(buy[t], sell[t - 1] - price);
                sell[t] = Math.max(sell[t], buy[t] + price);
            }
        }

        return sell[k];
    }

    public static void main(String[] args) {
        int[] prices1 = {3, 2, 6, 5, 0, 3};
        int k1 = 2;
        System.out.println("Test Case 1: " + maxProfit(k1, prices1)); // Expected: 7

        int[] prices2 = {2, 4, 1};
        int k2 = 2;
        System.out.println("Test Case 2: " + maxProfit(k2, prices2)); // Expected: 2

        int[] prices3 = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        int k3 = 4;
        System.out.println("Test Case 3: " + maxProfit(k3, prices3)); // Expected: 13

        int[] prices4 = {};
        int k4 = 3;
        System.out.println("Test Case 4: " + maxProfit(k4, prices4)); // Expected: 0

        int[] prices5 = {1, 2};
        int k5 = 1;
        System.out.println("Test Case 5: " + maxProfit(k5, prices5)); // Expected: 1
    }
}
