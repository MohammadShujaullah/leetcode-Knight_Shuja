class Solution {
    private int find(int i, int parents[]) {
        if (i == parents[i]) {
            return i;

        }
        return parents[i] = find(parents[i], parents);
    }

    private void union(int x, int y, int parents[], int rank[]) {
        // path compresion and rank
        int p_x = find(x, parents);
        int p_y = find(y, parents);

        if (p_x == p_y) {
            return;
        }
        if (rank[p_x] > rank[p_y]) {
            parents[p_y] = p_x;
        } else if (rank[p_x] < rank[p_y]) {
            parents[p_x] = p_y;
        } else {
            parents[p_x] = p_y;
            rank[p_y]++;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        int parents[] = new int[n];
        int rank[] = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;

        }
        if (connections.length < n - 1) {
            return -1;
        }
        int components = n;
        for (int[] u : connections) {
            if (find(u[0],parents) != find(u[1],parents)) { // if parent does not match
                union(u[0], u[1],parents,rank);
                components--;
            }
        }
        return components-1;

    }
}