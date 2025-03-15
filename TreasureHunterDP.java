//Using DP Approach to solve the problem
public class TreasureHunterDP {

    public static int collectMaxTreasure(int[][] map) {
        int rows = map.length, cols = map[0].length;
        //Constraint
        if (rows < 1 || rows > 100 || cols < 1 || cols > 100) { 
            throw new IllegalArgumentException("Grid size must be within 1 <= N, M <= 100");
        }

        int[][] treasure = new int[rows][cols];

        treasure[0][0] = map[0][0]; // Starting point

        // Fill the first row and column
        for (int c = 1; c < cols; c++) 
            treasure[0][c] = treasure[0][c - 1] + map[0][c];
        for (int r = 1; r < rows; r++) 
            treasure[r][0] = treasure[r - 1][0] + map[r][0];

        // Fill the rest of the table
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (map[r][c] < 0 || map[r][c] > 1000) {
                    throw new IllegalArgumentException("Grid values must be within 0 <= grid[r][j] <= 1000");
                }
                treasure[r][c] = Math.max(treasure[r - 1][c], treasure[r][c - 1]) + map[r][c];
            }
        }
        return treasure[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] map = {
            {5, 1, 7, 4},
            {2, 8, 3, 9},
            {6, 4, 5, 2}
        };

        System.out.println("Output: " + collectMaxTreasure(map));

        // This approach only looks at the best move from the top or left at each step.
        // It can't "see" the full path ahead to choose a sequence of moves that leads to 32.
        // To get 32, the best path is: Right -> Right -> Right -> Down -> Down.
        // This path requires going right 3 times before moving down, which this DP approach can't find.
    }
}