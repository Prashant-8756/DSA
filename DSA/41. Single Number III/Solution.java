import java.util.Arrays;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int setBit = xor & -xor;

        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & setBit) == 0) {
                num1 ^= num; // Group 1
            } else {
                num2 ^= num; // Group 2
            }
        }

        return new int[] { num1, num2 };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] result = solution.singleNumber(nums);
        
        System.out.println("The two unique numbers are: " + Arrays.toString(result));
    }
}
