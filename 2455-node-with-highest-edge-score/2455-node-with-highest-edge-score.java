class Solution {
    public int edgeScore(int[] edges) {

        long indegree[] = new long[edges.length];

        for (int i = 0; i < edges.length; i++) {
            indegree[edges[i]] += i;
        }

        Long max = Long.MIN_VALUE;
        int indx = -1;
        for (int i = edges.length-1; i>=0; i--) {
            if (indegree[i] >=max) {
                max = indegree[i];
                indx = i;
            }
        }
        return indx;

    }
}