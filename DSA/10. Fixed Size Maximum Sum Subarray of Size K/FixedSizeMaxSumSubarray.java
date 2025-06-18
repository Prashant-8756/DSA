public class FixedSizeMaxSumSubarray {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int maxSum = maxSumSubarrayOfSizeK(arr, k);
        System.out.println("Maximum sum of subarray of size " + k + " is: " + maxSum);
    }

    public static int maxSumSubarrayOfSizeK(int[] arr, int k) {
        int maxSum = 0;
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k]; 
            maxSum = Math.max(maxSum, windowSum); 
        }

        return maxSum;
    }
}
