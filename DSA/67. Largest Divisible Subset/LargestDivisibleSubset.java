import java.util.*;

public class LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] = size of largest subset ending at i
        int[] prev = new int[n]; // prev[i] = previous index in subset
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i = prev[i]) {
            result.add(nums[i]);
            if (prev[i] == -1) break;
        }

        Collections.reverse(result);
        return result;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8};
        List<Integer> subset = largestDivisibleSubset(nums);
        System.out.println("Largest Divisible Subset: " + subset);
    }
}