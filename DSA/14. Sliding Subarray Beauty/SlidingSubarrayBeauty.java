import java.util.*;

public class SlidingSubarrayBeauty {
    public static int[] subarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        NavigableMap<Integer, Integer> window = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            window.put(nums[i], window.getOrDefault(nums[i], 0) + 1);
            
            if (i >= k) {
                int leftNum = nums[i - k];
                window.put(leftNum, window.get(leftNum) - 1);
                if (window.get(leftNum) == 0) {
                    window.remove(leftNum);
                }
            }

            if (i >= k - 1) {
                int beauty = 0;
                if (window.size() >= x) {
                    int min = window.firstKey();    // Smallest element in the window
                    int max = window.lastKey();     // Largest element in the window
                    beauty = max - min;
                }

                int countLessEqualX = 0;
                for (int num : window.keySet()) {
                    if (num <= x) {
                        countLessEqualX += window.get(num);
                    }
                }

                result[i - k + 1] = (countLessEqualX >= x) ? beauty : 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        int x = 2;
        int[] beauty = subarrayBeauty(nums, k, x);
        System.out.println(Arrays.toString(beauty));
    }
}
