class Solution {
    boolean isCycle;

    private void CycleDFS(Map<Integer, ArrayList<Integer>> mp, int u, boolean visited[], boolean inRecurssion[],
            Stack<Integer> st) {
        visited[u] = true;
        inRecurssion[u] = true;

        if (mp.get(u) != null) {
            for (int v : mp.get(u)) {
                if (!visited[v]) {
                    CycleDFS(mp, v, visited, inRecurssion, st);

                } else if (inRecurssion[v] == true) {
                    isCycle = true;

                    return;
                }
            }
        }
        inRecurssion[u]=false;
        st.push(u);
        return;

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // this question directly wants you to find the ,totpological sorted array of
        // the course , and if not find the totpological array , then return empty array

        ArrayList<Integer> result = new ArrayList<>();

        if (prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++)
                result.add(i);
            return result.stream().mapToInt(i -> i).toArray();
        }

        Map<Integer, ArrayList<Integer>> mp = new HashMap<>();

        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prerequise = edge[1];

            if (!mp.containsKey(prerequise)) {
                mp.put(prerequise, new ArrayList<>());

            }
            mp.get(prerequise).add(course);

        }
        boolean visited[] = new boolean[numCourses];
        boolean inRecurssion[] = new boolean[numCourses];
        isCycle = false;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                CycleDFS(mp, i, visited, inRecurssion, st);
            }

        }
        if (isCycle == true) {
            return new int[] {};

        }

        while (!st.isEmpty())

        {

            result.add(st.pop());

        }

        return result.stream().mapToInt(i -> i).toArray();
    }

}