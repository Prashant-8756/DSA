public class MissingNumber {
    public static int findMissingNumber(int[] nums) {
        int n = nums.length + 1; // Since one number is missing
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 6}; // Missing number is 3
        System.out.println("Missing number: " + findMissingNumber(nums));
    }
}