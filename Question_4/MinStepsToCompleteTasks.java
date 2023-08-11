package CourseWork.Question_4;
//4.a
import java.util.*;

public class MinStepsToCompleteTasks {
    // Compute minimum steps with graph topology sort
    public static int minSteps(int N, int[][] prerequisites) {
        // Building graph as adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[N + 1];// Tracking in-degrees

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        // Add directed edges
        for (int[] prereq : prerequisites) {
            int x = prereq[0];
            int y = prereq[1];
            graph.get(x).add(y);
            inDegree[y]++;
        }
        // Initialize queue with nodes having 0 in-degree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        // Perform topology sort
        int steps = 0;
        while (!queue.isEmpty()) {
            // Process all nodes for current step
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                // Reduce in-degree of neighbors
                for (int neighbor : graph.get(current)) {
                    inDegree[neighbor]--;
                     // Add neighbor to queue if in-degree becomes 0
                    if (inDegree[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }
            steps++;// Increment steps
        }
        // Checking for cycle
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] > 0) {
                return -1; // There's a cycle, can't complete all tasks
            }
        }

        return steps;
    }

    public static void main(String[] args) {
        int N = 3;
        int[][] prerequisites = {{1, 3}, {2, 3}};
        // Get minimum steps
        int result = minSteps(N, prerequisites);
        System.out.println("Minimum steps: " + result);
    }
}
/*
Key Steps
    Build graph from prerequisites
    Track in-degrees of nodes
    Add 0 in-degree nodes to queue
    Decrement neighbor's in-degree when visiting -steps increment when queue size > 0
    Return -1 if any node has in-degree > 0 at end
 */

