public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 }; 
            } else if (sum < target) {
                left++; 
            } else {
                right--; 
            }
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        TwoSumII solution = new TwoSumII();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(numbers, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
