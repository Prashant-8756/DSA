import java.util.Arrays;

public class  NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); 
        int[] stack = new int[n];
        int top = -1; 

        for (int i = 0; i < 2 * n; i++) {
            int currentIndex = i % n;

            while (top >= 0 && nums[stack[top]] < nums[currentIndex]) {
                int index = stack[top--]; 
                result[index] = nums[currentIndex]; 
            }

            if (i < n) {
                stack[++top] = currentIndex; 
            }
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElementII solution = new NextGreaterElementII();
        int[] nums = {1, 2, 1};
        int[] result = solution.nextGreaterElements(nums);
        System.out.println(Arrays.toString(result)); // Output: [2, -1, 2]
    }
}
