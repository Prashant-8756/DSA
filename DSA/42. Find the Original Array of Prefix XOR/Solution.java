public class Solution {
    public int[] findOriginalArray(int[] prefix) {
        int n = prefix.length;
        int[] original = new int[n];
        
        original[0] = prefix[0];
        
        for (int i = 1; i < n; i++) {
            original[i] = prefix[i] ^ prefix[i - 1];
        }
        
        return original;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prefix = {5, 2, 0, 3, 1}; // Example prefix XOR array
        int[] original = solution.findOriginalArray(prefix);
        
    for (int num : original) {
            System.out.print(num + " ");
        }
    }
}
