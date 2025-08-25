public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }

        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] dp = new int[rows][cols];

        dp[rows - 1][cols - 1] = Math.max(1, 1 - dungeon[rows - 1][cols - 1]);

        for (int j = cols - 2; j >= 0; j--) {
            dp[rows - 1][j] = Math.max(1, dp[rows - 1][j + 1] - dungeon[rows - 1][j]);
        }

        for (int i = rows - 2; i >= 0; i--) {
            dp[i][cols - 1] = Math.max(1, dp[i + 1][cols - 1] - dungeon[i][cols - 1]);
        }

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                int minHealthOnExit = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, minHealthOnExit - dungeon[i][j]);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        DungeonGame game = new DungeonGame();

        // Test case 1
        int[][] dungeon1 = {
            {-2, -3, 3},
            {-5, -10, 1},
            {10, 30, -5}
        };
        System.out.println("Minimum HP needed (Test Case 1): " + game.calculateMinimumHP(dungeon1)); // Output: 7

        int[][] dungeon2 = {
            {0, -2, -3},
            {-5, -10, 1},
            {10, 30, -5}
        };
        System.out.println("Minimum HP needed (Test Case 2): " + game.calculateMinimumHP(dungeon2)); // Output: 6

        int[][] dungeon3 = {
            {1, -2, 0},
            {0, -1, 1},
            {2, 0, -1}
        };
        System.out.println("Minimum HP needed (Test Case 3): " + game.calculateMinimumHP(dungeon3)); // Output: 1
    }
}
