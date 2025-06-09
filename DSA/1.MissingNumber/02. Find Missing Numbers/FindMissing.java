import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindMissing {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 6, 7, 9}; // Missing 3, 5, 8, 10
        int n = 10; // Range from 1 to n

        List<Integer> missingNumbers = findMissingNumbers(numbers, n);
        System.out.println("Missing numbers: " + missingNumbers);
    }

    public static List<Integer> findMissingNumbers(int[] numbers, int n) {
        Set<Integer> numberSet = new HashSet<>();
        
        for (int number : numbers) {
            numberSet.add(number);
        }

        List<Integer> missingNumbers = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            if (!numberSet.contains(i)) {
                missingNumbers.add(i);
            }
        }

        return missingNumbers;
    }
}
