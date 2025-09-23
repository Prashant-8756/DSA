import java.util.*;

public class AlienDictionary {
    
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        
        Set<Character> chars = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                chars.add(c);
            }
        }
        
        Map<Character, Set<Character>> adj = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            boolean foundDiff = false;
            for (int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    adj.computeIfAbsent(c1, k -> new HashSet<>()).add(c2);
                    foundDiff = true;
                    break;
                }
            }
            if (!foundDiff && w1.length() > w2.length()) {
                return "";
            }
        }
        
        Map<Character, Integer> indeg = new HashMap<>();
        for (char c : chars) {
            indeg.put(c, 0);
        }
        for (char u : adj.keySet()) {
            for (char v : adj.get(u)) {
                indeg.put(v, indeg.get(v) + 1);
            }
        }
        
        Queue<Character> queue = new LinkedList<>();
        for (char c : chars) {
            if (indeg.get(c) == 0) {
                queue.offer(c);
            }
        }
        
        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()) {
            char u = queue.poll();
            order.append(u);
            if (adj.containsKey(u)) {
                for (char v : adj.get(u)) {
                    indeg.put(v, indeg.get(v) - 1);
                    if (indeg.get(v) == 0) {
                        queue.offer(v);
                    }
                }
            }
        }
        
        if (order.length() == chars.size()) {
            return order.toString();
        } else {
            return "";
        }
    }
    
    public static void main(String[] args) {
        AlienDictionary solution = new AlienDictionary();
        
        // Test Case 1: Standard case
        String[] words1 = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println("Test 1 Input: " + Arrays.toString(words1));
        System.out.println("Expected: wertf");
        System.out.println("Output: " + solution.alienOrder(words1));
        System.out.println();
        
        // Test Case 2: Simple case
        String[] words2 = {"z", "x"};
        System.out.println("Test 2 Input: " + Arrays.toString(words2));
        System.out.println("Expected: zx");
        System.out.println("Output: " + solution.alienOrder(words2));
        System.out.println();
        
        // Test Case 3: Cycle detection (invalid)
        String[] words3 = {"z", "x", "z"};
        System.out.println("Test 3 Input: " + Arrays.toString(words3));
        System.out.println("Expected: \"\" (cycle)");
        System.out.println("Output: " + solution.alienOrder(words3));
        System.out.println();
        
        // Test Case 4: Invalid prefix order
        String[] words4 = {"ab", "a"};
        System.out.println("Test 4 Input: " + Arrays.toString(words4));
        System.out.println("Expected: \"\" (invalid prefix)");
        System.out.println("Output: " + solution.alienOrder(words4));
        System.out.println();
        
        // Test Case 5: Valid prefix order
        String[] words5 = {"a", "ab"};
        System.out.println("Test 5 Input: " + Arrays.toString(words5));
        System.out.println("Expected: ab");
        System.out.println("Output: " + solution.alienOrder(words5));
        System.out.println();
        
        // Test Case 6: Empty input
        String[] words6 = {};
        System.out.println("Test 6 Input: " + Arrays.toString(words6));
        System.out.println("Expected: \"\"");
        System.out.println("Output: " + solution.alienOrder(words6));
        System.out.println();
        
        // Test Case 7: Single word
        String[] words7 = {"z"};
        System.out.println("Test 7 Input: " + Arrays.toString(words7));
        System.out.println("Expected: z");
        System.out.println("Output: " + solution.alienOrder(words7));
        System.out.println();
    }
}
