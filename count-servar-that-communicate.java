class Solution {
    public int countServers(int[][] grid) {
        int numRows = grid.length; // Number of rows in the grid
        int numCols = grid[0].length; // Number of columns in the grid
      
        // Arrays to store the count of servers in each row and column
        int[] rowCount = new int[numRows];
        int[] colCount = new int[numCols];
      
        // First iteration to fill in the rowCount and colCount arrays
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; ++j) {
                // Count servers in each row and column
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
      
        // Counter for the total number of connected servers
        int connectedServers = 0;
      
        // Second iteration to count the servers that can communicate
        // Servers can communicate if they are not the only one in their row or column
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; ++j) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    connectedServers++;
                }
            }
        }
      
        // Return the number of connected servers
        return connectedServers;
    }
}
