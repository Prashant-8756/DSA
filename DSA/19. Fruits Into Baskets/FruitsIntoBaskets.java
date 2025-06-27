import java.util.HashMap;

public class FruitsIntoBaskets {
    public int totalFruits(int[] fruits) {
        HashMap<Integer, Integer> fruitCount = new HashMap<>();
        int left = 0, maxFruits = 0;

        for (int right = 0; right < fruits.length; right++) {
            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);

            while (fruitCount.size() > 2) {
                fruitCount.put(fruits[left], fruitCount.get(fruits[left]) - 1);
                if (fruitCount.get(fruits[left]) == 0) {
                    fruitCount.remove(fruits[left]);
                }
                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }

    public static void main(String[] args) {
        FruitsIntoBaskets solution = new FruitsIntoBaskets();
        int[] fruits = {1, 2, 1};
        System.out.println("Maximum number of fruits: " + solution.totalFruits(fruits)); // Output: 3

        int[] fruits2 = {0, 1, 2, 2};
        System.out.println("Maximum number of fruits: " + solution.totalFruits(fruits2)); // Output: 3

        int[] fruits3 = {1, 2, 3, 2, 2};
        System.out.println("Maximum number of fruits: " + solution.totalFruits(fruits3)); // Output: 4
    }
}
