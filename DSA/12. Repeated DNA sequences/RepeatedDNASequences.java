import java.util.*;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        Set<String> added = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String seq = s.substring(i, i + 10);
            if (seen.contains(seq)) {
                if (!added.contains(seq)) {
                    result.add(seq);
                    added.add(seq);
                }
            } else {
                seen.add(seq);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RepeatedDNASequences solution = new RepeatedDNASequences();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> repeatedSequences = solution.findRepeatedDnaSequences(s);
        System.out.println(repeatedSequences); // Output: ["AAAAACCCCC", "CCCCCAAAAA"]
    }
}
