class Solution {

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        int count = 0;

        int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

        int grid[][] = new int[m][n];

        //   Place guards and walls

        for (int g[] : guards) {
            grid[g[0]][g[1]] = 1;

        }
        for (int w[] : walls) {
            grid[w[0]][w[1]] = -1;

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {

                    for (int d[] : dir) {
                        int newx = d[0] + i;
                        int newy = d[1] + j;

                       while (newx >= 0 && newx < m && newy >= 0 && newy < n) {   // in place of isSafe
                            if (grid[newx][newy] == -1 || grid[newx][newy] == 1) break;
                            grid[newx][newy] = 2;
                            newx += d[0];
                            newy += d[1];
                        }
                    }
                }

            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;

    }
}