public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] test1 = {1, 1, 0, 1, 1, 1};  
        int[] test2 = {1, 0, 1, 1, 0, 1};  
        int[] test3 = {};                   
        int[] test4 = {0, 0, 0};            
        int[] test5 = {1, 1, 1, 1};         
        
        System.out.println("Test 1: " + solution.findMaxConsecutiveOnes(test1));
        System.out.println("Test 2: " + solution.findMaxConsecutiveOnes(test2));
        System.out.println("Test 3: " + solution.findMaxConsecutiveOnes(test3));
        System.out.println("Test 4: " + solution.findMaxConsecutiveOnes(test4));
        System.out.println("Test 5: " + solution.findMaxConsecutiveOnes(test5));
    }
}

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        
        for (int num : nums) {
            if (num == 1) {
                currentCount++;
            } else {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 0;
            }
        }
        
        maxCount = Math.max(maxCount, currentCount);
        return maxCount;
    }
}
