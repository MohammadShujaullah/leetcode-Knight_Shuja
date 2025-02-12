class Solution {
    private long DFS(Map<Integer, ArrayList<Integer>> mp, int u, boolean visited[]) {
        visited[u] = true;
        long size = 1;  // count itself

        if (mp.get(u) != null) {
            for (int v : mp.get(u)) {
                if (!visited[v]) {
                    size += DFS(mp, v, visited);
                }
            }
        }
        return size;

    }

    public long countPairs(int n, int[][] edges) {
        Map<Integer, ArrayList<Integer>> mp = new HashMap<>();

        // Build adjacency list (undirected graph)
        for (int[] edge : edges) {
            mp.putIfAbsent(edge[0], new ArrayList<>());
            mp.putIfAbsent(edge[1], new ArrayList<>()); // this method is of map is important

            mp.get(edge[0]).add(edge[1]);
            mp.get(edge[1]).add(edge[0]); // Add both directions
        }
        long totalcount = n;
        long result = 0;
        boolean visited[] = new boolean[n];

        for (int u = 0; u < n; u++) {

            if (!visited[u]) {
                long sizeOfComponent = DFS(mp, u, visited);

                result += (sizeOfComponent) * (totalcount - sizeOfComponent);
                totalcount -= sizeOfComponent;
            }

        }
        return result;

    }
}