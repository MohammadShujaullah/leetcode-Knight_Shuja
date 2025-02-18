import java.util.*;

class Node {

    int key;
    int value1;
    int value2;

    public Node(int key, int value1, int value2) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;

    }

}

class Solution {
    private boolean isSafe(int x, int y, int[][] heights) {
        return (x >= 0 && x < heights.length && y >= 0 && y < heights[0].length);

    }

    public int minimumEffortPath(int[][] heights) {
        int[][] directions = {
                { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }
        };
        int n = heights.length;
        int m = heights[0].length;

       
        // result is used to store the minimum effort ,asked in the question
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = Integer.MAX_VALUE;

            }
        }
        result[0][0] = 0; // distance of source to source is zero

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.key));

        pq.add(new Node(0, 0, 0));
        while (!pq.isEmpty()) {
            Node pair = pq.poll();   //  time log(n)

            int dist = pair.key;

            int a = pair.value1;
            int b = pair.value2;
            if(a==n-1 && b==m-1){    // when we reach at last of the cell , then the current dist is the answer
                return dist;          
            }

            for (int[] s : directions) {
                int x_ = a + s[0];
                int y_ = b + s[1];
                if (isSafe(x_, y_, heights)) {
                    int diff = Math.abs(heights[a][b] - heights[x_][y_]);
                    int maxdiff = Math.max(diff, dist);

                    if (maxdiff < result[x_][y_]) {
                        result[x_][y_] = maxdiff;
                        pq.add(new Node(maxdiff, x_, y_));
                    }
                }

            }
        }

        return result[n - 1][m - 1];

    }
}