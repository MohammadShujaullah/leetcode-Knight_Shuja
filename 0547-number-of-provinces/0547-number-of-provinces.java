class Solution {
    int n;
    private void DFS( int[][] isConnected, int u, boolean visited[]) {
        visited[u] = true;

        for (int v=0;v<n;v++) {
            if (!visited[v] &&  isConnected[u][v]==1) {
                DFS( isConnected, v, visited);
            }

        }

    }

    public int findCircleNum(int[][] isConnected) {

        // IN THIS question we can see no. of provinces can be find ,by no. of dfs call
        // make by graph ,when there is disconnected grapg also present
         n = isConnected.length;

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
                DFS( isConnected, i, visited); // this DFS is upto when one province is ends, then return back to this line and
                                     // then we increse count
                count++;
            }
        }
        return count;

    }
}