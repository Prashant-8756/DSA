import java.util.HashSet;
import java.util.Set;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> travelDays = new HashSet<>();
        for (int day : days) {
            travelDays.add(day);
        }

        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];

        for (int day = 1; day <= lastDay; day++) {
            if (!travelDays.contains(day)) {
                dp[day] = dp[day - 1];
                continue;
            }

            int cost1 = dp[Math.max(0, day - 1)] + costs[0];
            int cost7 = dp[Math.max(0, day - 7)] + costs[1];
            int cost30 = dp[Math.max(0, day - 30)] + costs[2];

            dp[day] = Math.min(cost1, Math.min(cost7, cost30));
        }

        return dp[lastDay];
    }

    public static void main(String[] args) {
        MinimumCostForTickets solution = new MinimumCostForTickets();

        // Test case 1
        int[] days1 = {1, 4, 6, 7, 8};
        int[] costs1 = {2, 7, 15};
        System.out.println("Minimum cost for test case 1: " + solution.mincostTickets(days1, costs1)); // Output: 9

        // Test case 2
        int[] days2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30};
        int[] costs2 = {2, 7, 15};
        System.out.println("Minimum cost for test case 2: " + solution.mincostTickets(days2, costs2)); // Output: 15

        // Test case 3
        int[] days3 = {1, 2, 3};
        int[] costs3 = {2, 7, 15};
        System.out.println("Minimum cost for test case 3: " + solution.mincostTickets(days3, costs3)); // Output: 6
    }
}
