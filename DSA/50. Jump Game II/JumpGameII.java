public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        JumpGameII jumpGame = new JumpGameII();

        // Test case 1
        int[] testCase1 = {2, 3, 1, 1, 4};
        System.out.println("Minimum jumps for test case 1: " + jumpGame.jump(testCase1)); // Output: 2

        // Test case 2
        int[] testCase2 = {2, 3, 0, 1, 4};
        System.out.println("Minimum jumps for test case 2: " + jumpGame.jump(testCase2)); // Output: 2
    }
}
