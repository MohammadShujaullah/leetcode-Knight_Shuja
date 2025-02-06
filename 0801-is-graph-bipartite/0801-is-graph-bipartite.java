class Solution {

    private boolean BFS(int[][]graph, int curr, int color[], int currcolor) {
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        color[curr] = currcolor;

        while (!q.isEmpty()) {
            int x = q.remove();

            for (int v : graph[x]) {
                if (color[v] == color[x]) {
                    return false;
                } else if (color[v] == -1) {
                    color[v] = 1 - color[x];
                    q.add(v);

                }
            }

        }
        return true;

    }

    public boolean isBipartite(int[][] graph) {

        // here in this question we have already ,adjecency list , so we directly use it 

        // adjecency list
         int V=graph.length;


        int color[] = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i <V; i++) {
            if (color[i] == -1) {
                if (!BFS(graph, i, color, 1)) {
                    return false;
                }
            }
        }
        return true;

    }
}