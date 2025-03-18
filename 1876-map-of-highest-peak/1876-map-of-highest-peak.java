class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;

        this.y = y;

    }
}

class Solution {
    private boolean isSafe(int x, int y, int[][] result) {
        int n = result.length;
        int m = result[0].length;
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

    public int[][] highestPeak(int[][] isWater) {
        int[][] directions = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

        int n = isWater.length;
        int m = isWater[0].length;

        Queue<Node> q = new LinkedList<>();

        int result[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    q.add(new Node(i, j));
                    result[i][j] = 0;

                } else {
                    result[i][j] = -1; // mrk as unvisited

                }

            }
        }

        while (!q.isEmpty()) {
            int N = q.size();
            while (N-- > 0) {
                Node points = q.remove();

                int i = points.x;
                int j = points.y;

                for (int[] dir : directions) {
                    int new_x = i + dir[0];
                    int new_y = j + dir[1];
                    if (isSafe(new_x, new_y, result) && result[new_x][new_y] == -1) {
                        result[new_x][new_y] = result[i][j] + 1;
                        q.add(new Node(new_x, new_y));

                    }
                }
            }
        }
        return result;

    }
}