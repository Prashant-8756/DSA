import java.util.*;

public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1; 

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) {
                    return level;
                }

                char[] wordChars = word.toCharArray();
                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;

                        wordChars[j] = c;
                        String newWord = new String(wordChars);

                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord); 
                        }
                    }
                    wordChars[j] = originalChar; 
                }
            }
            level++;
        }

        return 0; 
    }

    public static void main(String[] args) {
        List<String> wordList1 = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println("Test case 1: " + ladderLength("hit", "cog", wordList1));
        // Expected output: 5 (hit -> hot -> dot -> dog -> cog)

        List<String> wordList2 = Arrays.asList("a","b","c");
        System.out.println("Test case 2: " + ladderLength("a", "c", wordList2));
        // Expected output: 2 (a -> c)

        List<String> wordList3 = Arrays.asList("hot","dot","dog","lot","log");
        System.out.println("Test case 3: " + ladderLength("hit", "cog", wordList3));
        // Expected output: 0 (cog not in word list)

        List<String> wordList4 = Arrays.asList("ted","tex","red","tax","tad","den","rex","pee");
        System.out.println("Test case 4: " + ladderLength("red", "tax", wordList4));
        // Expected output: 4 (red -> ted -> tad -> tax)
    }
}
