import java.util.*;

public class NetworkConnected {
    static class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                if (rank[px] < rank[py]) {
                    parent[px] = py;
                } else {
                    parent[py] = px;
                    if (rank[px] == rank[py]) {
                        rank[px]++;
                    }
                }
            }
        }
    }

    public static int makeConnected(int n, int[][] connections) {
        if (n <= 1) return 0;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : connections) {
            uf.union(edge[0], edge[1]);
        }
        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < n; i++) {
            roots.add(uf.find(i));
        }
        int components = roots.size();
        return components - 1;
    }

    public static void main(String[] args) {
        int n1 = 4;
        int[][] conn1 = {{0, 1}, {0, 2}, {1, 3}};
        System.out.println("Test 1: " + makeConnected(n1, conn1)); // Expected: 0

        int n2 = 6;
        int[][] conn2 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}, {2, 5}};
        System.out.println("Test 2: " + makeConnected(n2, conn2)); // Expected: 0

        int n3 = 6;
        int[][] conn3 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println("Test 3: " + makeConnected(n3, conn3)); // Expected: 1

        int n4 = 3;
        int[][] conn4 = {};
        System.out.println("Test 4: " + makeConnected(n4, conn4)); // Expected: 2

        int n5 = 1;
        int[][] conn5 = {};
        System.out.println("Test 5: " + makeConnected(n5, conn5)); // Expected: 0

        int n6 = 2;
        int[][] conn6 = {};
        System.out.println("Test 6: " + makeConnected(n6, conn6)); // Expected: 1
    }
}
