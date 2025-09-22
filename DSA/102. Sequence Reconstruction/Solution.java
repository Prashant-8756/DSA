import java.util.*;

public class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;
        
        List<Integer>[] graph = new List[n + 1];
        int[] indegree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (num < 1 || num > n || !seen.add(num)) {
                return false; // Invalid permutation
            }
        }
        
        for (List<Integer> seq : sequences) {
            for (int i = 0; i < seq.size() - 1; i++) {
                int u = seq.get(i);
                int v = seq.get(i + 1);
                if (u < 1 || u > n || v < 1 || v > n) {
                    continue; // Invalid, but skip
                }
                if (!graph[u].contains(v)) {
                    graph[u].add(v);
                    indegree[v]++;
                }
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int index = 0; // Position in nums
        while (!queue.isEmpty() && index < n) {
            if (queue.size() != 1) {
                return false;
            }
            
            int curr = queue.poll();
            if (curr != nums[index]) {
                return false; // Doesn't match the given sequence
            }
            
            for (int neighbor : graph[curr]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
            
            index++;
        }
        
        return index == n && queue.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Valid Unique Reconstruction
        System.out.println("Test Case 1:");
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> sequences1 = new ArrayList<>();
        sequences1.add(Arrays.asList(1, 2));
        sequences1.add(Arrays.asList(2, 3));
        System.out.println("Input: nums = [1,2,3], sequences = [[1,2],[2,3]]");
        System.out.println("Output: " + solution.sequenceReconstruction(nums1, sequences1));
        System.out.println("Expected: true");
        System.out.println();

        // Test Case 2: Multiple Possible Orders (Invalid)
        System.out.println("Test Case 2:");
        int[] nums2 = {1, 2, 3};
        List<List<Integer>> sequences2 = new ArrayList<>();
        sequences2.add(Arrays.asList(1, 2));
        sequences2.add(Arrays.asList(1, 3));
        System.out.println("Input: nums = [1,2,3], sequences = [[1,2],[1,3]]");
        System.out.println("Output: " + solution.sequenceReconstruction(nums2, sequences2));
        System.out.println("Expected: false");
        System.out.println();

        // Test Case 3: Cycle (Invalid)
        System.out.println("Test Case 3:");
        int[] nums3 = {1, 2, 3};
        List<List<Integer>> sequences3 = new ArrayList<>();
        sequences3.add(Arrays.asList(1, 2));
        sequences3.add(Arrays.asList(2, 3));
        sequences3.add(Arrays.asList(3, 1));
        System.out.println("Input: nums = [1,2,3], sequences = [[1,2],[2,3],[3,1]]");
        System.out.println("Output: " + solution.sequenceReconstruction(nums3, sequences3));
        System.out.println("Expected: false");
        System.out.println();

        // Test Case 4: Invalid Permutation
        System.out.println("Test Case 4:");
        int[] nums4 = {1, 2, 2};
        List<List<Integer>> sequences4 = new ArrayList<>();
        sequences4.add(Arrays.asList(1, 2));
        System.out.println("Input: nums = [1,2,2], sequences = [[1,2]]");
        System.out.println("Output: " + solution.sequenceReconstruction(nums4, sequences4));
        System.out.println("Expected: false");
        System.out.println();

        // Test Case 5: Empty Sequences (Valid if Permutation)
        System.out.println("Test Case 5:");
        int[] nums5 = {1};
        List<List<Integer>> sequences5 = new ArrayList<>();
        System.out.println("Input: nums = [1], sequences = []");
        System.out.println("Output: " + solution.sequenceReconstruction(nums5, sequences5));
        System.out.println("Expected: true");
        System.out.println();
    }
}
