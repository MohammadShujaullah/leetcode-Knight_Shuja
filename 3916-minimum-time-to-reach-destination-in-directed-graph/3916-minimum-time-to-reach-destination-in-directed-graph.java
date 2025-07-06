class Solution {
    public int minTime(int n, int[][] edges) {
          Map<Integer, List<int[]>> dalmurecio = new HashMap<>();
        for (int[] edge : edges) {
            dalmurecio.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2], edge[3]});
        }

      
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0}); 

        int[] visitedTime = new int[n]; // jis node pr app ho , uss node pr anne main kitna time lga , ye store krta ha 
        Arrays.fill(visitedTime, Integer.MAX_VALUE);// future node pr ham pahunche hi nahi h, to time unka infinty rakhte han , just for joy
        visitedTime[0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];

            if (node == n - 1) return time;

            if (time > visitedTime[node]) continue;

            List<int[]> neighbors = dalmurecio.getOrDefault(node, new ArrayList<>());
            for (int[] edge : neighbors) {
                int next = edge[0];
                int start = edge[1];
                int end = edge[2];

                int waitTime = Math.max(time, start);
                if (waitTime <= end && waitTime + 1 < visitedTime[next]) {
                    visitedTime[next] = waitTime + 1;
                    pq.offer(new int[]{waitTime + 1, next});
                }
            }
        }

        return -1;
    }
}