public class CountNiceSubarrays {
    public int countNiceSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int oddCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0) {
                oddCount++;
            }

            while (oddCount > k) {
                if (nums[left] % 2 != 0) {
                    oddCount--;
                }
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        CountNiceSubarrays cna = new CountNiceSubarrays();
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(cna.countNiceSubarrays(nums, k)); // Output: 10

        int[] nums2 = {2, 4, 6};
        k = 1;
        System.out.println(cna.countNiceSubarrays(nums2, k)); // Output: 0
    }
}
