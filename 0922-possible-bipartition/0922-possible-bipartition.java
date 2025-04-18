 import java.util.*;

class Solution {
    
    public boolean isBipartite(Map<Integer, List<Integer>> adj, int node, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(node);
        color[node] = 1;
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            
            for (int v : adj.getOrDefault(u, new ArrayList<>())) {
                if (color[v] == color[u]) {
                    return false;
                }
                if (color[v] == -1) {
                    color[v] = 1 - color[u];
                    queue.offer(v);
                }
            }
        }
        
        return true;
    }
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for (int[] pair : dislikes) {
            int u = pair[0];
            int v = pair[1];
            
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        
        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                if (!isBipartite(adj, i, color)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
