class Solution {
    public long gridGame(int[][] grid) {
        // Initialize the answer to the maximum possible value.
        long answer = Long.MAX_VALUE;
        // Variables to store the sum of the top row (sumTopRow) and the sum of the bottom row (sumBottomRow).
        long sumTopRow = 0, sumBottomRow = 0;
      
        // Calculate the initial sum of the top row.
        for (int value : grid[0]) {
            sumTopRow += value;
        }
      
        // Find the length of the grid rows.
        int numberOfColumns = grid[0].length;
      
        // Iterate over every column to decide the best path.
        for (int column = 0; column < numberOfColumns; ++column) {
            // Subtract the current value of the top row because the robot will move right from here.
            sumTopRow -= grid[0][column];
            // Calculate the minimum of the maximum of the two paths (top and bottom).
            answer = Math.min(answer, Math.max(sumTopRow, sumBottomRow));
            // Add the current value to the sum of the bottom row as the robot can move down.
            sumBottomRow += grid[1][column];
        }
        // Return the minimum result after traversing all columns.
        return answer;
    }
}
