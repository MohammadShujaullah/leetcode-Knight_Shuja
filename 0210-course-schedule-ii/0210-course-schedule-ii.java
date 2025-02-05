class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // this question directly wants you to find the ,totpological sorted array of
        // the course , and if not find the totpological array , then return empty array
        ArrayList<Integer> result = new ArrayList<>();
        if (prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++)
                result.add(i);
            return result.stream().mapToInt(i -> i).toArray();
        }

        // indegree
        int indegree[] = new int[numCourses];

        Map<Integer, ArrayList<Integer>> mp = new HashMap<>();

        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prerequise = edge[1];

            if (!mp.containsKey(prerequise)) {
                mp.put(prerequise, new ArrayList<>());

            }
            mp.get(prerequise).add(course);

            // calculate the indegree
            indegree[course]++;

        }

        int count = 0;

        // intro queue
        Queue<Integer> q = new LinkedList<>();

        // populate the queue with indegree ==0
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                count++;

                result.add(i);

            }
        }

        // step 3 BFS
        while (!q.isEmpty()) {
            int u = q.remove();
            for (int v : mp.getOrDefault(u, new ArrayList<>())) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.add(v);
                    count++;

                    result.add(v);
                }
            }
        }

        if (count == numCourses) {
            return result.stream().mapToInt(i -> i).toArray();
        }
        return new int[] {};
    }
}