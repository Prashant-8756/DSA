import java.util.*;

public class KSmallestPairs {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0] + a[1], b[0] + b[1])
        );

        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0}); 
        }

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int num1 = current[0];
            int num2 = current[1];
            int index2 = current[2];

            result.add(new int[]{num1, num2});

            if (index2 + 1 < nums2.length) {
                minHeap.offer(new int[]{num1, nums2[index2 + 1], index2 + 1});
            }
        }

        return result;
    }

    public static void main(String[] args) {
        KSmallestPairs solution = new KSmallestPairs();
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;

        List<int[]> result = solution.kSmallestPairs(nums1, nums2, k);
        for (int[] pair : result) {
            System.out.println(Arrays.toString(pair));
        }
    }
}
