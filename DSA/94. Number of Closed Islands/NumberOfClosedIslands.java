public class NumberOfClosedIslands {

    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, cols - 1);
        }
        for (int j = 0; j < cols; j++) {
            dfs(grid, 0, j);
            dfs(grid, rows - 1, j);
        }

        int closedIslands = 0;
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (grid[i][j] == 0) {
                    closedIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return closedIslands;
    }

    private void dfs(int[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 1) {
            return;
        }

        grid[i][j] = 1; 

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    
    public static void main(String[] args) {
        NumberOfClosedIslands solution = new NumberOfClosedIslands();

        int[][] grid1 = {
            {1,1,1,1,1,1,1,0},
            {1,0,0,0,0,1,1,0},
            {1,0,1,0,1,1,1,0},
            {1,0,0,0,0,1,0,1},
            {1,1,1,1,1,1,1,0}
        };
        System.out.println("Closed Islands in grid1: " + solution.closedIsland(grid1)); // Output: 2

        int[][] grid2 = {
            {0,0,1,0,0},
            {0,1,0,1,0},
            {0,1,1,1,0}
        };
        System.out.println("Closed Islands in grid2: " + solution.closedIsland(grid2)); // Output: 1

        int[][] grid3 = {
            {1,1,1,1,1,1,1},
            {1,0,0,0,0,0,1},
            {1,0,1,1,1,0,1},
            {1,0,1,0,1,0,1},
            {1,0,1,1,1,0,1},
            {1,0,0,0,0,0,1},
            {1,1,1,1,1,1,1}
        };
        System.out.println("Closed Islands in grid3: " + solution.closedIsland(grid3)); // Output: 2
    }
}
