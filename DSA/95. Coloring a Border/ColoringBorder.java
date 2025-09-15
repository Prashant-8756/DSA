import java.util.Arrays;

public class ColoringBorder {

    public static int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int rows = grid.length, cols = grid[0].length;
        int originalColor = grid[r0][c0];
        boolean[][] visited = new boolean[rows][cols];

        dfs(grid, r0, c0, originalColor, color, visited);

        return grid;
    }

    private static void dfs(int[][] grid, int r, int c, int originalColor, int newColor, boolean[][] visited) {
        int rows = grid.length, cols = grid[0].length;
        visited[r][c] = true;

        boolean isBorder = false;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for (int[] dir : directions) {
            int nr = r + dir[0], nc = c + dir[1];
            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] != originalColor) {
                isBorder = true;
            } else if (!visited[nr][nc]) {
                dfs(grid, nr, nc, originalColor, newColor, visited);
            }
        }

        if (isBorder) {
            grid[r][c] = newColor;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 1, 2},
            {1, 1, 2, 2},
            {1, 2, 2, 2},
            {2, 2, 2, 2}
        };
        int r0 = 1, c0 = 1, newColor = 3;

        System.out.println("Original grid:");
        printGrid(grid);

        int[][] result = colorBorder(grid, r0, c0, newColor);

        System.out.println("\nGrid after coloring border:");
        printGrid(result);
    }

    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }
}
