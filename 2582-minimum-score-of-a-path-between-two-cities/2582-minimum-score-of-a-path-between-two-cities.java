class Pair {
    int sec;
    int distance;

    public Pair(int sec, int distance) {
        this.sec = sec;
        this.distance = distance;

    }
}

class Solution {

    private void DFS(Map<Integer, ArrayList<Pair>> mp, int u, boolean visited[], int []result) {
        visited[u] = true;
        if(mp.get(u)==null) return ;  // safty checking

        for (Pair v : mp.get(u)) {
            result[0] = Math.min(result[0], v.distance);
            if (!visited[v.sec]) {
                DFS(mp, v.sec, visited, result);

            }

        }
    }

    public int minScore(int n, int[][] roads) {
        Map<Integer, ArrayList<Pair>> mp = new HashMap<>();
        int result[] =new int[n] ;     // result should be int []  so that , it passes by reference, not by value
        Arrays.fill(result,Integer.MAX_VALUE);

        for (int x[] : roads) {
            mp.putIfAbsent(x[0], new ArrayList<>());
            mp.putIfAbsent(x[1], new ArrayList<>());
            mp.get(x[0]).add(new Pair(x[1], x[2]));
            mp.get(x[1]).add(new Pair(x[0], x[2]));
        }

        boolean visited[] = new boolean[n+1];
        if(!mp.containsKey(1))return -1;   // if 1 is not present in the graph

        DFS(mp, 1, visited, result);
        return result[0];
    }
}