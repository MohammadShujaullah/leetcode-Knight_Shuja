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
    private boolean isSafe(int x, int y, int[][] grid) {
        return (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length);
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int[][] directions = {
                { 1, 1 }, { 0, 1 }, { 1, 0 }, { -1, 0 },
                { 0, -1 }, { -1, -1 }, { 1, -1 }, { -1, 1 }
        }; // 1,1 maens diagonal, 1,0 means right, -1,0 left and so on

        int n = grid.length;
        int m = grid[0].length;

        if (m == 0 || n == 0 || grid[0][0] != 0) {
            return -1;

        }
        int[][] result = new int[n][m]; /// decalaration of result
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.key));
        pq.add(new Node(0, 0, 0));
        result[0][0] = 0;

        while (!pq.isEmpty()) {

            Node pair = pq.poll();
            int dist = pair.key;
            int a = pair.value1;
            int b = pair.value2;

            for (int[] s : directions) {
                int x_ = a + s[0];
                int y_ = b + s[1];
                int d = 1;
                if (isSafe(x_, y_, grid) && grid[x_][y_] == 0 && d + dist < result[x_][y_]) {
                    pq.add(new Node(d + dist, x_, y_));
                    result[x_][y_] = d + dist;

                }

            }

        }
        if (result[n - 1][m - 1] == Integer.MAX_VALUE) {
            return -1;
        }
        return result[n - 1][m - 1] + 1;

    }
}