import java.util.Arrays;

public class LongestIncreasingSubsequence {
    
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        int length = 0;
        
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, length, num);
            if (i < 0) {
                i = -(i + 1); 
            }
            dp[i] = num;
            
            if (i == length) {
                length++;
            }
        }
        
        return length;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS for nums1: " + lis.lengthOfLIS(nums1)); // Output: 4
        
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println("Length of LIS for nums2: " + lis.lengthOfLIS(nums2)); // Output: 4
        
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println("Length of LIS for nums3: " + lis.lengthOfLIS(nums3)); // Output: 1
        
        int[] nums4 = {};
        System.out.println("Length of LIS for nums4: " + lis.lengthOfLIS(nums4)); // Output: 0
    }
}
