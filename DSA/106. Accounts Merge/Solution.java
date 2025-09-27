import java.util.*;

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); 
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}

class Solution {
    public List<List<String>> mergeAccounts(List<List<String>> accounts) {
        int n = accounts.size();
        if (n == 0) return new ArrayList<>();

        UnionFind uf = new UnionFind(n);
        Map<String, Integer> emailToAccount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = accounts.get(i).get(0);
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailToAccount.containsKey(email)) {
                    uf.union(i, emailToAccount.get(email));
                } else {
                    emailToAccount.put(email, i);
                }
            }
        }

       
        Map<Integer, List<Integer>> rootToAccounts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            rootToAccounts.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<Integer> component : rootToAccounts.values()) {
            Set<String> emails = new HashSet<>();
            for (int idx : component) {
                List<String> account = accounts.get(idx);
                for (int j = 1; j < account.size(); j++) {
                    emails.add(account.get(j));
                }
            }
            List<String> merged = new ArrayList<>(emails);
            Collections.sort(merged);
            String name = accounts.get(component.get(0)).get(0); 
            merged.add(0, name);
            result.add(merged);
        }

    
        result.sort((a, b) -> a.get(0).compareTo(b.get(0)));
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<String>> accounts1 = Arrays.asList(
            Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
            Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
            Arrays.asList("Mary", "mary@mail.com"),
            Arrays.asList("John", "johnnybravo@mail.com")
        );
        List<List<String>> result1 = solution.mergeAccounts(accounts1);
        System.out.println("Test Case 1 (Sample):");
        printResult(result1);
        // Expected: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"], ["John","johnnybravo@mail.com"], ["Mary","mary@mail.com"]]

      
        List<List<String>> accounts2 = Arrays.asList(
            Arrays.asList("Alice", "alice@mail.com"),
            Arrays.asList("Bob", "bob@mail.com", "alice@mail.com"),
            Arrays.asList("Charlie", "charlie@mail.com", "bob@mail.com")
        );
        List<List<String>> result2 = solution.mergeAccounts(accounts2);
        System.out.println("\nTest Case 2 (All Merged):");
        printResult(result2);
        // Expected: [["Alice","alice@mail.com","bob@mail.com","charlie@mail.com"]]

        List<List<String>> accounts3 = Arrays.asList(
            Arrays.asList("David", "david1@mail.com"),
            Arrays.asList("Eva", "eva@mail.com"),
            Arrays.asList("Frank", "frank@mail.com")
        );
        List<List<String>> result3 = solution.mergeAccounts(accounts3);
        System.out.println("\nTest Case 3 (No Overlaps):");
        printResult(result3);
        // Expected: [["David","david1@mail.com"], ["Eva","eva@mail.com"], ["Frank","frank@mail.com"]]

        List<List<String>> accounts4 = new ArrayList<>();
        List<List<String>> result4 = solution.mergeAccounts(accounts4);
        System.out.println("\nTest Case 4 (Empty):");
        printResult(result4);
        // Expected: []
    }

    private static void printResult(List<List<String>> result) {
        for (List<String> account : result) {
            System.out.println(account);
        }
    }
}
