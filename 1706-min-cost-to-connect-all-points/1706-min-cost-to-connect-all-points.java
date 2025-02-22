class Node {
    int node, weight;

    public Node(int node, int weight) {
        this.node = node;
        this.weight = weight;

    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        HashMap<Integer, ArrayList<int[]>> mp = new HashMap<>();

        int n = points.length;

        /// making adjecency map
        for (int i = 0; i < n; i++) { // i am taking indeces of points[][] as node
            mp.put(i, new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                    mp.get(i).add(new int[] { j, dist });

                }
            }
        }
        boolean isMST[] = new boolean[n];
        int totalcost = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.weight));
        pq.add(new Node(0, 0)); // initially distance is zero from zero node

        while (!pq.isEmpty()) {
            Node pair = pq.poll();

            int node = pair.node;
            int dist = pair.weight;

            if (isMST[node]) {
                continue;
            }
            isMST[node] = true;
            totalcost += dist;

            for (int m[] : mp.get(node)) {
                int nextnode = m[0];
                int nextdist = m[1];

                if (!isMST[nextnode]) {
                    pq.add(new Node(nextnode, nextdist));
                }
            }
        }

        return totalcost;
    }
}