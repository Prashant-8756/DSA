public class SetMismatch {

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int duplicate = -1;
        int missing = -1;

        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                duplicate = Math.abs(nums[i]);
            } else {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        if (missing == -1) {
            missing = n;
        }

        return new int[]{duplicate, missing};
    }

    public static void main(String[] args) {
        SetMismatch solution = new SetMismatch();

        int[] nums1 = {1, 2, 2, 4};
        int[] result1 = solution.findErrorNums(nums1);
        System.out.println("Input: {1, 2, 2, 4}, Output: " + result1[0] + ", " + result1[1]); // Expected: 2, 3
    }
}
