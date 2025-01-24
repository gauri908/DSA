class Solution {
    private int[] nodeColors;
    private int[][] graph;

    // Method to determine all the eventual safe nodes in a graph
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        nodeColors = new int[n]; // Initialize array to store the state of each node
        this.graph = graph; // Assign graph to class variable for easy access
        List<Integer> safeNodes = new ArrayList<>(); // List to store eventual safe nodes
      
        // Iterate over each node to determine if it's a safe node
        for (int i = 0; i < n; ++i) {
            if (isNodeSafe(i)) { // If the current node is safe, add it to the list
                safeNodes.add(i);
            }
        }
        return safeNodes; // Return the final list of safe nodes
    }

    // Helper method - Conducts a depth-first search to determine if a node is safe.
    // A node is considered safe if all its possible paths lead to a terminal node.
    private boolean isNodeSafe(int node) {
        if (nodeColors[node] > 0) { // If the node is already visited, return its state
            return nodeColors[node] == 2; // Return true if the node leads to a terminal node, i.e., is safe (color coded as 2)
        }
        nodeColors[node] = 1; // Mark the node as visited (color coded as 1)
      
        // Explore all connected nodes recursively
        for (int neighbor : graph[node]) {
            if (!isNodeSafe(neighbor)) { // If any connected node is not safe, then this node is not safe either
                return false;
            }
        }
      
        nodeColors[node] = 2; // Since all connected nodes are safe, mark this node as safe (color coded as 2)
        return true; // Return true indicating the node is safe
    }
}
