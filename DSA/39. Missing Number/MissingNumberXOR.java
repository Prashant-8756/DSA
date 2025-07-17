public class MissingNumberXOR {
    
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        
        for (int num : nums) {
            xor ^= num;
        }
        
        return xor;
    }

    public static void main(String[] args) {
        int[] test1 = {3, 0, 1};  // Missing 2
        int[] test2 = {0, 1};     // Missing 2
        int[] test3 = {9, 6, 4, 2, 3, 5, 7, 0, 1}; // Missing 8
        
        System.out.println("Missing number in [3, 0, 1]: " + missingNumber(test1));
        System.out.println("Missing number in [0, 1]: " + missingNumber(test2));
        System.out.println("Missing number in [9, 6, 4, 2, 3, 5, 7, 0, 1]: " + missingNumber(test3));
    }
}
