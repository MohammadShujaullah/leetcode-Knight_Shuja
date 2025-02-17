import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Adjacency List/////// using HashMap

        HashMap<Integer, List<int[]>> mp = new HashMap<>();

        for (int[] edge : times) {
            mp.putIfAbsent(edge[0], new ArrayList<>());

            mp.get(edge[0]).add(new int[] { edge[1], edge[2] });
            // directed Graph
        }

        if (!mp.containsKey(k)) {
            return -1;
        }
        int[] result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[k] = 0; // Distance of source (1) is always 0
        // Min-Heap (Priority Queue) for Dijkstra's Algorithm
        PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> pq = new PriorityQueue<>(
                Comparator.comparingInt(AbstractMap.SimpleEntry::getKey));

        pq.add(new AbstractMap.SimpleEntry<>(0, k));

        while (!pq.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> p = pq.poll();
            int distance = p.getKey();
            int node = p.getValue();

            if (!mp.containsKey(node))
                continue; // Skip if node has no edges

            for (int[] v : mp.get(node)) {
                int adjNode = v[0], weight = v[1];

                if (distance + weight < result[adjNode]) {
                    result[adjNode] = distance + weight;
                    pq.add(new AbstractMap.SimpleEntry<>(result[adjNode], adjNode));
                }
            }
        }

        // If destination is unreachable, return [-1] Helps Detect Unreachable Nodes

        for (int i = 1; i <= n; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                return -1;
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (result[i] > max) {
                max = result[i];
            }
        }
        return max;

    }

}