import java.util.*;

class TreeAncestor {
    private int[][] up;
    private int LOG;

    public TreeAncestor(int n, int[] parent) {
        LOG = 16; 
        up = new int[n][LOG];
        
        for (int i = 0; i < n; i++) {
            up[i][0] = parent[i];
        }
        
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                if (up[i][j - 1] != -1) {
                    up[i][j] = up[up[i][j - 1]][j - 1];
                } else {
                    up[i][j] = -1;
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < LOG; j++) {
            if ((k & (1 << j)) != 0) {
                if (node == -1) return -1;
                node = up[node][j];
            }
        }
        return node;
    }
}

public class Main {
    public static void main(String[] args) {
        int n1 = 7;
        int[] parent1 = {-1, 0, 0, 1, 1, 2, 2};
        TreeAncestor ta1 = new TreeAncestor(n1, parent1);
        
        System.out.println("Test Case 1:");
        System.out.println("getKthAncestor(3, 1): " + ta1.getKthAncestor(3, 1)); 
        System.out.println("getKthAncestor(5, 2): " + ta1.getKthAncestor(5, 2)); 
        System.out.println("getKthAncestor(6, 3): " + ta1.getKthAncestor(6, 3)); 
        System.out.println("getKthAncestor(0, 1): " + ta1.getKthAncestor(0, 1)); 
        
        int n2 = 4;
        int[] parent2 = {-1, 0, 1, 2};
        TreeAncestor ta2 = new TreeAncestor(n2, parent2);
        
        System.out.println("\nTest Case 2:");
        System.out.println("getKthAncestor(3, 1): " + ta2.getKthAncestor(3, 1));
        System.out.println("getKthAncestor(3, 2): " + ta2.getKthAncestor(3, 2)); 
        System.out.println("getKthAncestor(3, 3): " + ta2.getKthAncestor(3, 3)); 
        System.out.println("getKthAncestor(3, 4): " + ta2.getKthAncestor(3, 4)); 
        
        int n3 = 1;
        int[] parent3 = {-1};
        TreeAncestor ta3 = new TreeAncestor(n3, parent3);
        
        System.out.println("\nTest Case 3:");
        System.out.println("getKthAncestor(0, 1): " + ta3.getKthAncestor(0, 1)); 
    }
}
