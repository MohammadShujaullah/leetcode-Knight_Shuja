 import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Graph Representation using Adjacency List
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] edge : prerequisites) {
            int course = edge[0], prerequisite = edge[1];

            adjList.putIfAbsent(prerequisite, new ArrayList<>());
            adjList.get(prerequisite).add(course);

            // Step 2: Calculate In-degree
            indegree[course]++;
        }

        // Step 3: Queue Initialization (Nodes with 0 In-degree)
        Queue<Integer> queue = new LinkedList<>();
        int count = 0; // Count of courses that can be taken

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        // Step 4: BFS Traversal
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (adjList.containsKey(curr)) {
                for (int next : adjList.get(curr)) {
                    indegree[next]--;

                    if (indegree[next] == 0) {
                        queue.add(next);
                        count++;
                    }
                }
            }
        }

        // Step 5: If all courses are completed, return true
        return count == numCourses;
    }
}
