class Solution {
    private void DFS(List<List<Integer>> rooms, int u, boolean visited[]) {
        visited[u] = true;
        for (int v : rooms.get(u)) {
            if (!visited[v]) {
                DFS(rooms, v, visited);
            }
        }

    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];

        DFS(rooms, 0, visited); // 0th room is already unlocked

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;

            }
        }
        return true;
    }
}