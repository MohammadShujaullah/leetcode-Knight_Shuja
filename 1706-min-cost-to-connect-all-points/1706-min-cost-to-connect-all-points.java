
class Solution {
    private int[] parent;
    private int[] rank;

    private int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    private void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent)
            return;

        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }
     private int kruskal(List<int[]> edges, int n) {
        int sum = 0;
        int edgesConnected = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            int parentU = find(u);
            int parentV = find(v);

            if (parentU != parentV) {
                union(u, v);
                sum += wt;
                edgesConnected++;
            }
        }

        // Check if we formed a spanning tree
        if (edgesConnected != n - 1) {
            System.out.println("It's not a MST");
        }

        return sum;
    }

    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();

        int n = points.length;
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        /// making adjecency List
        for (int i = 0; i < n; i++) { // i am taking indeces of points[][] as node

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                    edges.add(new int[] { i, j, dist });

                }
            }
        }

        // step1 , now we have to sort the list the

        edges.sort(Comparator.comparingInt(a -> a[2]));
        return kruskal(edges,n);

    }
}