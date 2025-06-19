public class Solution {
    public int numOfSubarrays(int[] arr, int threshold) {
        int n = arr.length;
        int count = 0;
        int requiredSum = threshold * n; 
        
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                int length = end - start + 1;
                long currentSum = prefixSum[end + 1] - prefixSum[start];
                if (currentSum * n >= length * threshold) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 2, 2, 2, 5, 5, 5, 8};
        int threshold = 5;
        int result = solution.numOfSubarrays(arr, threshold);
        System.out.println("Number of subarrays: " + result);
    }
}
