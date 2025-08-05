import java.util.HashMap;

public class TargetSum {
    private HashMap<String, Integer> memo;

    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return findWays(nums, 0, target);
    }

    private int findWays(int[] nums, int index, int target) {
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }

        String key = index + "," + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int add = findWays(nums, index + 1, target - nums[index]);
        int subtract = findWays(nums, index + 1, target + nums[index]);

        memo.put(key, add + subtract);
        return add + subtract;
    }

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int result = ts.findTargetSumWays(nums, target);
        
        System.out.println("Number of ways to reach target sum: " + result); // Output: 5
    }
}
