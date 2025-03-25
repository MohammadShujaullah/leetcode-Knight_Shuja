class Solution {

    private void DFS(Map<Integer, ArrayList<Integer>> mp, int u, boolean visited[]) {
        visited[u] = true;

        for (int v : mp.get(u)) {
            if (!visited[v]) {
                DFS(mp, v, visited);
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination)
            return true;
        // adjecency list // undirected graph

        Map<Integer, ArrayList<Integer>> mp = new HashMap<>();

        for (int[] edge : edges) {
            mp.putIfAbsent(edge[0], new ArrayList<>());
            mp.putIfAbsent(edge[1], new ArrayList<>());

            mp.get(edge[0]).add(edge[1]);
            mp.get(edge[1]).add(edge[0]);

        }

        // we have to simply apply dfs, and check visited[distination]!=false

        // or

        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[n];
        q.add(source);

        while (!q.isEmpty()) {

            int x = q.remove();

            visited[x] = true;

            for (int v : mp.get(x)) {
                if (!visited[v]) {
                    visited[v] = true;

                    q.add(v);

                }
            }
        }

        return visited[destination];

    }
}