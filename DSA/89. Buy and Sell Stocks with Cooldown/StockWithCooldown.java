public class StockWithCooldown {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;
        int hold = -prices[0];
        int sold = 0;
        int rest = 0;

        for (int i = 1; i < n; i++) {
            int prevHold = hold;
            int prevSold = sold;
            int prevRest = rest;

            hold = Math.max(prevHold, prevRest - prices[i]);
            sold = prevHold + prices[i];
            rest = Math.max(prevRest, prevSold);
        }

        return Math.max(sold, rest);
    }

    public static void main(String[] args) {
        StockWithCooldown solver = new StockWithCooldown();

        int[] prices1 = {1, 2, 3, 0, 2};
        System.out.println("Test case 1: " + solver.maxProfit(prices1)); // Expected: 3

        int[] prices2 = {1};
        System.out.println("Test case 2: " + solver.maxProfit(prices2)); // Expected: 0

        int[] prices3 = {1, 2, 4};
        System.out.println("Test case 3: " + solver.maxProfit(prices3)); // Expected: 3

        int[] prices4 = {6, 1, 3, 2, 4, 7};
        System.out.println("Test case 4: " + solver.maxProfit(prices4)); // Expected: 6
    }
}
