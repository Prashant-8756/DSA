import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> dp = new HashMap<>();
        int maxLength = 1;

        for (String word : words) {
            dp.put(word, 1); 
            for (int i = 0; i < word.length(); i++) {
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(predecessor)) {
                    dp.put(word, Math.max(dp.get(word), dp.get(predecessor) + 1));
                }
            }
            maxLength = Math.max(maxLength, dp.get(word));
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestStringChain lsc = new LongestStringChain();
        
        // Test case
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        int result = lsc.longestStrChain(words);
        System.out.println("The length of the longest string chain is: " + result);
    }
}
