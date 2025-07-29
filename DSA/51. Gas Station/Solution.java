public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];

            // If currentGas drops below 0, we cannot start from 'startIndex'
            if (currentGas < 0) {
                startIndex = i + 1; // Move to the next station
                currentGas = 0; // Reset current gas
            }
        }

        // If total gas is less than total cost, it's impossible to complete the circuit
        return totalGas < totalCost ? -1 : startIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        System.out.println(solution.canCompleteCircuit(gas1, cost1)); // Output: 3

        // Test case 2
        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        System.out.println(solution.canCompleteCircuit(gas2, cost2)); // Output: -1

        // Test case 3
        int[] gas3 = {5, 1, 2, 3, 4};
        int[] cost3 = {4, 4, 1, 5, 1};
        System.out.println(solution.canCompleteCircuit(gas3, cost3)); // Output: 4
    }
}
