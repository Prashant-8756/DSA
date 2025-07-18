public class SingleNumberII {
    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        
        for (int num : nums) {
            twos |= ones & num;
            ones ^= num;
            int threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        
        return ones;
    }

    public static void main(String[] args) {
        int[] test1 = {2, 2, 3, 2}; // Expected: 3
        int[] test2 = {0, 1, 0, 1, 0, 1, 99}; // Expected: 99
        int[] test3 = {1}; // Expected: 1
        
        System.out.println("Single number in [2, 2, 3, 2]: " + singleNumber(test1));
        System.out.println("Single number in [0, 1, 0, 1, 0, 1, 99]: " + singleNumber(test2));
        System.out.println("Single number in [1]: " + singleNumber(test3));
    }
}
