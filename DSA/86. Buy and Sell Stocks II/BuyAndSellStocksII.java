public class BuyAndSellStocksII {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test case 1: " + maxProfit(prices1)); // Expected output: 7

        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Test case 2: " + maxProfit(prices2)); // Expected output: 4

        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println("Test case 3: " + maxProfit(prices3)); // Expected output: 0

        int[] prices4 = {5};
        System.out.println("Test case 4: " + maxProfit(prices4)); // Expected output: 0

        int[] prices5 = {};
        System.out.println("Test case 5: " + maxProfit(prices5)); // Expected output: 0
    }
}
