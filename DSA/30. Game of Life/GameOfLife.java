import java.util.Arrays;

public class GameOfLife {

    public static void main(String[] args) {
        int[][] board = {
            {0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1}
        };

        int generations = 5;
        System.out.println("Initial board:");
        printBoard(board);

        for (int i = 0; i < generations; i++) {
            gameOfLife(board);
            System.out.println("\nGeneration " + (i + 1) + ":");
            printBoard(board);
        }
    }

    public static void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}, 
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}  
        };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = 0;

                for (int[] dir : directions) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];

                    if (ni >= 0 && ni < rows && nj >= 0 && nj < cols &&
                        (board[ni][nj] == 1 || board[ni][nj] == -1)) { 
                        liveNeighbors++;
                    }
                }

                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = -1; 
                } else if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 2;  
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0; 
                } else if (board[i][j] == 2) {
                    board[i][j] = 1; 
                }
            }
        }
    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "■ " : "□ ");
            }
            System.out.println();
        }
    }
}
