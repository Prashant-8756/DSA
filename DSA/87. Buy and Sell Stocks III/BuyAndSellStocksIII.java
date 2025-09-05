public class BuyAndSellStocksIII {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;

        for (int price : prices) {
            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy + price);
            secondBuy = Math.max(secondBuy, firstSell - price);
            secondSell = Math.max(secondSell, secondBuy + price);
        }

        return secondSell;
    }

    // Test cases
    public static void main(String[] args) {
        int[][] testCases = {
            {3,3,5,0,0,3,1,4},  // Expected: 6
            {1,2,3,4,5},        // Expected: 4
            {7,6,4,3,1},        // Expected: 0
            {1},                // Expected: 0
            {1,2,4,2,5,7,2,4,9,0} // Expected: 13
        };

        for (int i = 0; i < testCases.length; i++) {
            int profit = maxProfit(testCases[i]);
            System.out.println("Test case " + (i+1) + ": Max Profit = " + profit);
        }
    }
}
