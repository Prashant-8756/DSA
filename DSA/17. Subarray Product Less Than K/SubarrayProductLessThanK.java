public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0; 

        int product = 1;
        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right]; 

            while (product >= k) {
                product /= nums[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK solution = new SubarrayProductLessThanK();
        int[] nums1 = {10, 5, 2, 6};
        int k1 = 100;
        System.out.println("Number of subarrays: " + solution.numSubarrayProductLessThanK(nums1, k1)); // Output: 8

        int[] nums2 = {1, 2, 3};
        int k2 = 0;
        System.out.println("Number of subarrays: " + solution.numSubarrayProductLessThanK(nums2, k2)); // Output: 0
    }
}
