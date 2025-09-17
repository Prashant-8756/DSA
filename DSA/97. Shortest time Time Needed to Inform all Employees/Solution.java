import java.util.*;

public class Solution {
    private List<List<Integer>> graph;
    private int[] informTime;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.informTime = informTime;
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                graph.get(manager[i]).add(i);
            }
        }

        return dfs(headID);
    }

    private int dfs(int manager) {
        int maxTime = 0;
        for (int subordinate : graph.get(manager)) {
            maxTime = Math.max(maxTime, dfs(subordinate));
        }
        return informTime[manager] + maxTime;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int n1 = 6;
        int headID1 = 2;
        int[] manager1 = {2, 2, -1, 2, 2, 2};
        int[] informTime1 = {0, 0, 1, 0, 0, 0};
        System.out.println("Test case 1 output: " + sol.numOfMinutes(n1, headID1, manager1, informTime1));
    
        int n2 = 7;
        int headID2 = 6;
        int[] manager2 = {1, 2, 3, 4, 5, 6, -1};
        int[] informTime2 = {0, 6, 5, 4, 3, 2, 1};
        System.out.println("Test case 2 output: " + sol.numOfMinutes(n2, headID2, manager2, informTime2));
    
        int n3 = 4;
        int headID3 = 0;
        int[] manager3 = {-1, 0, 0, 1};
        int[] informTime3 = {2, 2, 0, 0};
        System.out.println("Test case 3 output: " + sol.numOfMinutes(n3, headID3, manager3, informTime3));
    }
}
