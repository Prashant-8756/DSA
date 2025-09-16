public class NumberOfEnclaves {
    private int rows, cols;
    private int[][] grid;

    public int numEnclaves(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            if (grid[r][0] == 1) dfs(r, 0);
            if (grid[r][cols - 1] == 1) dfs(r, cols - 1);
        }
        for (int c = 0; c < cols; c++) {
            if (grid[0][c] == 1) dfs(0, c);
            if (grid[rows - 1][c] == 1) dfs(rows - 1, c);
        }

        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) count++;
            }
        }
        return count;
    }

    private void dfs(int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0) return;

        grid[r][c] = 0; 

        dfs(r + 1, c);
        dfs(r - 1, c);
        dfs(r, c + 1);
        dfs(r, c - 1);
    }

    public static void main(String[] args) {
        NumberOfEnclaves solver = new NumberOfEnclaves();

        int[][] grid1 = {
            {0,0,0,0},
            {1,0,1,0},
            {0,1,1,0},
            {0,0,0,0}
        };
        System.out.println("Enclaves in grid1: " + solver.numEnclaves(grid1)); // Expected: 3

        int[][] grid2 = {
            {0,1,1,0},
            {0,0,1,0},
            {0,0,1,0},
            {0,0,0,0}
        };
        System.out.println("Enclaves in grid2: " + solver.numEnclaves(grid2)); // Expected: 0

        int[][] grid3 = {
            {1,1,1,1},
            {1,0,0,1},
            {1,0,0,1},
            {1,1,1,1}
        };
        System.out.println("Enclaves in grid3: " + solver.numEnclaves(grid3)); // Expected: 0
    }
}
