class Solution {

    private void DFS(int[][] graph, int u, List<List<Integer>> result, List<Integer> l) {

        l.add(u);
        if (u == graph.length - 1) {
            result.add(new ArrayList<>(l)); // when we reach the last node, we must add the new list
        }

        else {
            for (int v : graph[u]) {

                DFS(graph, v, result, l);

            }
        }

        l.remove(l.size() - 1);

    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        // due to DAG ,then neccessity of visited array is not here

        DFS(graph, 0, result, l);

        return result;

    }
}