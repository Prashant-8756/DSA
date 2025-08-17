import java.util.Arrays;

public class NumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int n = nums.length;
        int[] lengths = new int[n]; 
        int[] counts = new int[n];  
        Arrays.fill(lengths, 1);
        Arrays.fill(counts, 1);

        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lengths[j] + 1 > lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j]; 
                    } else if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j]; 
                    }
                }
            }
            maxLength = Math.max(maxLength, lengths[i]);
        }

        int totalCount = 0;
        for (int i = 0; i < n; i++) {
            if (lengths[i] == maxLength) {
                totalCount += counts[i];
            }
        }

        return totalCount;
    }

    public static void main(String[] args) {
        NumberOfLIS solution = new NumberOfLIS();

        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Number of LIS: " + solution.findNumberOfLIS(nums1)); // Output: 4

        int[] nums2 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println("Number of LIS: " + solution.findNumberOfLIS(nums2)); // Output: 1

        int[] nums3 = {3, 2, 5, 6, 3, 7, 8, 1, 2, 3};
        System.out.println("Number of LIS: " + solution.findNumberOfLIS(nums3)); // Output: 2

        int[] nums4 = {1, 2, 4, 3, 5, 4, 7, 2};
        System.out.println("Number of LIS: " + solution.findNumberOfLIS(nums4)); // Output: 3
    }
}
