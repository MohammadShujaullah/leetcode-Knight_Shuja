class Solution {
    int n;

    private void DFS(int[] edges, int u, int dist[], boolean vis[]) {
        vis[u] = true;

        int v = edges[u];
        if (v != -1 && !vis[v]) {
            vis[v] = true;
            dist[v] = 1 + dist[u];
            DFS(edges, v, dist, vis);
        }

    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        n = edges.length;
        int dist1[] = new int[n];
        int dist2[] = new int[n];

        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        dist1[node1] = 0;
        dist2[node2] = 0;

        boolean vis1[] = new boolean[n];
        boolean vis2[] = new boolean[n];

        DFS(edges, node1, dist1, vis1);
        DFS(edges, node2, dist2, vis2);

        int maxdisIdx = -1;
        int mindistancetillnow = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
             
            int maxD = Math.max(dist1[i], dist2[i]);

            if (mindistancetillnow > maxD) {
                mindistancetillnow = maxD;
                maxdisIdx = i;
            }
        }

        return maxdisIdx;

    }
}