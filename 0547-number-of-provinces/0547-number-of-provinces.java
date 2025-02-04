class Solution {
    private void DFS(Map<Integer, ArrayList<Integer>> mp, int u, boolean visited[]) {
        visited[u] = true;

        for (int v : mp.get(u)) {
            if (!visited[v]) {
                DFS(mp, v, visited);
            }

        }

    }

    public int findCircleNum(int[][] isConnected) {

        // IN THIS question we can see no. of provinces can be find ,by no. of dfs call
        // make by graph ,when there is disconnected grapg also present
        int n = isConnected.length;

        Map<Integer, ArrayList<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    if (!mp.containsKey(i)) {
                        mp.put(i, new ArrayList<>());
                    }
                    mp.get(i).add(j);
                }

            }
        }

        int count = 0;

        boolean visited[] = new boolean[mp.size()];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(mp, i, visited);
                count++;
            }
        }
        return count;

    }
}