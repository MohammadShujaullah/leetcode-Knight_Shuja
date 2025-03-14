class Solution {

    //////////////////////////////////
    private Map<Integer, ArrayList<Integer>> buildadj(int[][] edges) {
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        for (int[] edge : edges) {
            adjList.putIfAbsent(edge[0], new ArrayList<>()); // undirected graph
            adjList.putIfAbsent(edge[1], new ArrayList<>());

            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);

        }
        return adjList;
    }

    ///////////////////////////////////
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        // biult adjecency list for both the tree
        Map<Integer, ArrayList<Integer>> adj1 = buildadj(edges1);
        Map<Integer, ArrayList<Integer>> adj2 = buildadj(edges2);

        // calculate the diameter
        int d1 = findDiameter(adj1);
        int d2 = findDiameter(adj2);

        int combined = (d1 + 1) / 2 + (d2 + 1) / 2+1;
        int result = Math.max(Math.max(d1, d2), combined);

        return result;

    }

    private int findDiameter(Map<Integer, ArrayList<Integer>> adj) {
        // first the BFS to find the farthest node from any arbitrary node( let 0)

        List<Integer> farthestNode = BFS(adj, 0); // it return the farthest node and max distance

        farthestNode = BFS(adj, farthestNode.get(0)); /// now , finding the diameter through farthestNode , which must
        /// be the another end of the diameter

        return farthestNode.get(1);

    }

    // BFS helper function to find the farthest node and its distance from the
    // source
    private List<Integer> BFS(Map<Integer, ArrayList<Integer>> adj, int source) {
        Queue<Integer> q = new LinkedList<>();

        // visted array or map
        HashMap<Integer, Integer> distance = new HashMap<>();

        q.add(source);
        distance.put(source, 0); // it is important to mark visit (distance map is behaves like a visited array)

        int farthest_node = source;
        int maxdimtr = 0;

        while (!q.isEmpty()) {
            int x = q.remove();
            int currdistance = distance.get(x);

            if (currdistance > maxdimtr) {
                maxdimtr = currdistance;
                farthest_node = x;

            }

            // update the farthest node

            // going on the neighbor
            for (int neighbor : adj.getOrDefault(x, new ArrayList<>())) {

                /// visited or not
                if (!distance.containsKey(neighbor)) {
                    distance.put(neighbor, currdistance + 1);

                    q.add(neighbor);
                }
            }

        }
        return Arrays.asList(farthest_node, maxdimtr);

    }

}