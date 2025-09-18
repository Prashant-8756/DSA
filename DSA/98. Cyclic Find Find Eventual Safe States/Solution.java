import java.util.*;

public class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n]; 
        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, state)) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    private boolean dfs(int node, int[][] graph, int[] state) {
        if (state[node] != 0) {
            return state[node] == 2;
        }

        state[node] = 1; 
        for (int nei : graph[node]) {
            if (!dfs(nei, graph, state)) {
                return false; 
            }
        }
        state[node] = 2;
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] graph1 = {
            {1,2},
            {2,3},
            {5},
            {0},
            {5},
            {},
            {}
        };
        System.out.println("Safe nodes for graph1: " + sol.eventualSafeNodes(graph1));
    
        int[][] graph2 = {
            {1,2,3,4},
            {1,2},
            {3,4},
            {0,4},
            {}
        };
        System.out.println("Safe nodes for graph2: " + sol.eventualSafeNodes(graph2));
    
        int[][] graph3 = {
            {1},
            {2},
            {3},
            {4},
            {}
        };
        System.out.println("Safe nodes for graph3: " + sol.eventualSafeNodes(graph3));
    }
}
