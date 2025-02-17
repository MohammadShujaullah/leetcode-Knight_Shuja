import java.util.*;

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
        Queue<AbstractMap.SimpleEntry<Integer, Integer>> q = new LinkedList<>();

        q.add(new AbstractMap.SimpleEntry<>(0, 0));
        grid[0][0] = 1; // visited

        int level = 0;

        while (!q.isEmpty()) {
            int N = q.size();
            while (N-- > 0) {
                AbstractMap.SimpleEntry<Integer, Integer> pair = q.poll();
                int a = pair.getKey();
                int b = pair.getValue();

                if (a == n - 1 && b == m - 1) {
                    return level + 1;

                }
                for (int[] s : directions) {
                    int x_ = a + s[0];
                    int y_ = b + s[1];
                    if (isSafe(x_, y_, grid) && grid[x_][y_] == 0) {
                        q.add(new AbstractMap.SimpleEntry<>(x_, y_));
                        grid[x_][y_] = 1;

                    }

                }

            }
            level++;

        }

        return -1;

    }
}