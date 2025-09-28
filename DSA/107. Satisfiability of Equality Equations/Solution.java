import java.util.Arrays;

class Solution {
    private int[] parent;
    private int[] rank;
    
    private void initialize(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) {
            return;
        }
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else {
            parent[py] = px;
            if (rank[px] == rank[py]) {
                rank[px]++;
            }
        }
    }
    
    public boolean equationsPossible(String[] equations) {
        initialize(26);
        
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int u = eq.charAt(0) - 'a';
                int v = eq.charAt(3) - 'a';
                union(u, v);
            }
        }
        
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int u = eq.charAt(0) - 'a';
                int v = eq.charAt(3) - 'a';
                if (find(u) == find(v)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        String[] eq1 = {"a==b", "b!=a"};
        System.out.println("Test 1: " + sol.equationsPossible(eq1)); // Expected: false
        
        String[] eq2 = {"a==b", "b==c", "c==a"};
        System.out.println("Test 2: " + sol.equationsPossible(eq2)); // Expected: true
        
        String[] eq3 = {"a==b", "b!=c", "c==a"};
        System.out.println("Test 3: " + sol.equationsPossible(eq3)); // Expected: false
        
        String[] eq4 = {"c==c", "f!=a", "f==b", "b==c"};
        System.out.println("Test 4: " + sol.equationsPossible(eq4)); // Expected: true
        
        String[] eq5 = {"a==b", "b==c", "a==c", "c!=c"};
        System.out.println("Test 5: " + sol.equationsPossible(eq5)); // Expected: false
    }
}
