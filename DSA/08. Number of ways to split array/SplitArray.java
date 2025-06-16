import java.util.HashMap;

public class SplitArray {
    public int waysToSplitArray(int[] nums) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        long prefixSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            prefixSum += nums[i];
            if (prefixSum >= (totalSum - prefixSum)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        SplitArray solution = new SplitArray();
        int[] nums = {10, 4, -8, 7}; 
        int result = solution.waysToSplitArray(nums);
        System.out.println("Number of ways to split the array: " + result);
    }
}
