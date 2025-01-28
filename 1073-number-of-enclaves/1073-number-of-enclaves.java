class Solution {
    int m, n;

    private void DFS(int[][] grid, int i, int j) { // for to practice dfs question, this is better example to use

        if (i < 0 || i >=m || j < 0 || j >=n || grid[i][j] == 0) { // if it is already 0,then return it
            return;
        }
        grid[i][j]=0;

        DFS(grid, i, j + 1);
        DFS(grid, i, j - 1);
        DFS(grid, i - 1, j);

        DFS(grid, i + 1, j);

    }

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // first col and last col pr dfs

        for (int row = 0; row < m; row++) {
            if (grid[row][0] == 1) {
                DFS(grid, row, 0);
            }
            if (grid[row][n - 1] == 1) {
                DFS(grid, row, n - 1);
            }
        }
        // first row and last row
        for (int col = 0; col < n; col++) {
            if (grid[0][col] == 1) {
                DFS(grid, 0, col);
            }
            if (grid[m - 1][col] == 1) {
                DFS(grid, m - 1, col);
            }
        }

        // iterate to count the remaining 1s ni the grid

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;

    }
}