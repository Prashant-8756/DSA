import java.util.Arrays;

public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1; 
        int boats = 0; 
        
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++; 
            }
            right--; 
            boats++; 
        }
        
        return boats; 
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] people = {1, 2, 3, 4, 5};
        int limit = 5;
        int result = solution.numRescueBoats(people, limit);
        
        System.out.println("Number of boats required: " + result); // Expected output: 3
    }
}
