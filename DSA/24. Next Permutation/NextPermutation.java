public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        NextPermutation solution = new NextPermutation();
        
        int[] nums1 = {1, 2, 3};
        solution.nextPermutation(nums1);
        System.out.println("Next permutation of [1,2,3]: " + java.util.Arrays.toString(nums1));
        
        int[] nums2 = {3, 2, 1};
        solution.nextPermutation(nums2);
        System.out.println("Next permutation of [3,2,1]: " + java.util.Arrays.toString(nums2));
        
        int[] nums3 = {1, 1, 5};
        solution.nextPermutation(nums3);
        System.out.println("Next permutation of [1,1,5]: " + java.util.Arrays.toString(nums3));
        
        int[] nums4 = {1, 3, 2};
        solution.nextPermutation(nums4);
        System.out.println("Next permutation of [1,3,2]: " + java.util.Arrays.toString(nums4));
    }
}
