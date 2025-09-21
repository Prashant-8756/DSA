import java.util.*;

public class StrangePrinterII {
    public boolean isPrintable(int[][] targetGrid) {
        int m = targetGrid.length, n = targetGrid[0].length;
        int maxColor = 0;
        for (int[] row : targetGrid) {
            for (int c : row) {
                maxColor = Math.max(maxColor, c);
            }
        }

        int[] minRow = new int[maxColor + 1];
        int[] maxRow = new int[maxColor + 1];
        int[] minCol = new int[maxColor + 1];
        int[] maxCol = new int[maxColor + 1];
        Arrays.fill(minRow, m);
        Arrays.fill(minCol, n);
        Arrays.fill(maxRow, -1);
        Arrays.fill(maxCol, -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int c = targetGrid[i][j];
                minRow[c] = Math.min(minRow[c], i);
                maxRow[c] = Math.max(maxRow[c], i);
                minCol[c] = Math.min(minCol[c], j);
                maxCol[c] = Math.max(maxCol[c], j);
            }
        }

        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= maxColor; i++) {
            graph.add(new HashSet<>());
        }

        for (int c = 1; c <= maxColor; c++) {
            if (maxRow[c] == -1) continue; // color not present
            for (int i = minRow[c]; i <= maxRow[c]; i++) {
                for (int j = minCol[c]; j <= maxCol[c]; j++) {
                    int insideColor = targetGrid[i][j];
                    if (insideColor != c) {
                        graph.get(c).add(insideColor);
                    }
                }
            }
        }

        int[] visited = new int[maxColor + 1]; // 0=unvisited,1=visiting,2=visited
        for (int c = 1; c <= maxColor; c++) {
            if (maxRow[c] == -1) continue;
            if (hasCycle(c, graph, visited)) return false;
        }
        return true;
    }

    private boolean hasCycle(int node, List<Set<Integer>> graph, int[] visited) {
        if (visited[node] == 1) return true; // cycle detected
        if (visited[node] == 2) return false; // already processed

        visited[node] = 1;
        for (int nei : graph.get(node)) {
            if (hasCycle(nei, graph, visited)) return true;
        }
        visited[node] = 2;
        return false;
    }

    public static void main(String[] args) {
        StrangePrinterII sp = new StrangePrinterII();

        int[][] targetGrid1 = {
            {1,1,1,1},
            {1,2,2,1},
            {1,2,2,1},
            {1,1,1,1}
        };
        System.out.println("Test case 1: " + sp.isPrintable(targetGrid1)); // Expected: true

        int[][] targetGrid2 = {
            {1,2,1},
            {2,1,2},
            {1,2,1}
        };
        System.out.println("Test case 2: " + sp.isPrintable(targetGrid2)); // Expected: false

        int[][] targetGrid3 = {
            {1,1,1},
            {1,1,1},
            {1,1,1}
        };
        System.out.println("Test case 3: " + sp.isPrintable(targetGrid3)); // Expected: true
    }
}
