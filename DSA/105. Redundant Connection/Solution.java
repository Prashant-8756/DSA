import java.util.Arrays;
public class Solution {
    
    static class UnionFind {
        int[] parent;
        int[] rank;
        
        public UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) {
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
        
        public boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return false; 
            }
            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else {
                parent[py] = px;
                if (rank[px] == rank[py]) {
                    rank[px]++;
                }
            }
            return true;
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length; 
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[]{}; 
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test Case 1: edges = [[1,2],[1,3],[2,3]]
        // Expected: [2,3] (removing [2,3] breaks the cycle)
        int[][] edges1 = {{1,2}, {1,3}, {2,3}};
        int[] res1 = sol.findRedundantConnection(edges1);
        System.out.println("Test Case 1: " + Arrays.toString(res1)); // Output: [2, 3]
        
        // Test Case 2: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
        // Expected: [1,4] (removing [1,4] breaks the cycle; [1,5] is fine as it extends the tree)
        int[][] edges2 = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        int[] res2 = sol.findRedundantConnection(edges2);
        System.out.println("Test Case 2: " + Arrays.toString(res2)); // Output: [1, 4]
        
        // Test Case 3: A larger example with cycle at the end
        // edges = [[1,2],[2,3],[3,4],[4,5],[1,5]]
        // Expected: [1,5]
        int[][] edges3 = {{1,2}, {2,3}, {3,4}, {4,5}, {1,5}};
        int[] res3 = sol.findRedundantConnection(edges3);
        System.out.println("Test Case 3: " + Arrays.toString(res3)); // Output: [1, 5]
    }
}
