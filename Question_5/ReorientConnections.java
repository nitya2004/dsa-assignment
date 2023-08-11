package CourseWork.Question_5;
// 5. b
import java.util.ArrayList;
import java.util.List;

public class ReorientConnections {
    // Graph represented as adjacency list 
    static List<List<Integer>> graph;
    static boolean[] visited;// Visited array for DFS
    static int[] reverseCount;// Count reversals needed for each node 

    // Calculate minimum reversals needed
    public static int minReorder(int n, int[][] connections) {
         // Build graph 
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // Add edges 
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            graph.get(from).add(to); // Forward edge 
            graph.get(to).add(-from); // Negative value to indicate reversed edge/  Backward edge  
        }
        // DFS traversal
        visited = new boolean[n];
        reverseCount = new int[n];

        dfs(0);
        
        // Count nodes needing reversal
        int totalReversals = 0;
        for (int count : reverseCount) {
            if (count > 0) {
                totalReversals++;
            }
        }

        return totalReversals;
    }
    // DFS traversal 
    private static void dfs(int node) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
             // Unvisited neighbor
            if (!visited[Math.abs(neighbor)]) {
                // Backward edge
                if (neighbor < 0) {
                    reverseCount[node]++;
                    neighbor = -neighbor;
                }
                dfs(neighbor);
                // Accumulate counts from subtree
                reverseCount[node] += reverseCount[neighbor];
            }
        }
    }

    public static void main(String[] args) {
        // Graph definition
        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        int result = minReorder(n, connections);
        System.out.println("Minimum number of reversals: " + result);
    }
}
/*
The key steps are:
    Build graph with forward and backward edges
    Use DFS to traverse graph
    Count backward edges and accumulate counts from subtree
    Nodes with non-zero count need to be reversed
 */
