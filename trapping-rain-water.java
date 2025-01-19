import java.util.PriorityQueue;

public class Solution {

    // Method to calculate the total trapped rainwater in the given height map
    public int trapRainWater(int[][] heightMap) {
        int rows = heightMap.length, cols = heightMap[0].length;
        boolean[][] visited = new boolean[rows][cols]; // Track visited cells
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]); // Min-heap based on height

        // Initialize the min-heap with the boundary cells and mark them as visited
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    minHeap.offer(new int[]{heightMap[i][j], i, j});
                    visited[i][j] = true;
                }
            }
        }

        int totalWater = 0; // Variable to store total trapped water
        // Direction vectors (up, right, down, left)
        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, 1, 0, -1};

        // Process cells in the priority queue
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            // Iterate over all four adjacent cells
            for (int k = 0; k < 4; ++k) {
                int newRow = current[1] + dirX[k], newCol = current[2] + dirY[k];

                // Check bounds and visited status of the adjacent cell
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]) {
                    // Update total water based on the height difference
                    totalWater += Math.max(0, current[0] - heightMap[newRow][newCol]);
                    // Mark the adjacent cell as visited
                    visited[newRow][newCol] = true;
                    // Add the adjacent cell to the priority queue with the max border height
                    minHeap.offer(new int[]{Math.max(current[0], heightMap[newRow][newCol]), newRow, newCol});
                }
            }
        }

        return totalWater; // Return the total amount of trapped rainwater
    }
}
