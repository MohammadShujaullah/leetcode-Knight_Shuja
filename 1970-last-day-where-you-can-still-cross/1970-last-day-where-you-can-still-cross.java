class Solution {
    int ROW;
    int COL;
    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private boolean dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= ROW || j < 0 || j >= COL || grid[i][j] == 1) {
            return false; // if the grid is already in the water or 1 then return false

        }
        if (i == ROW - 1) {
            return true;
        }
        grid[i][j] = 1;   // to protect form backtrack
        for (int[] dir : directions) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if (dfs(grid, new_i, new_j)) {
                return true;

            }
        }
        return false;

    }

    private boolean cancross(List<int[]> cells, int day) {
        int[][] grid = new int[ROW][COL];
        // NEW 2D ARRSY TO STORE THE VSLUER OF 1 OR 0

        // WE HAVE TO PUT 1 TILL THE MID AND AFTER THAT WE HAVE TO CHECK AT MID+1
        for (int i = 0; i <= day; i++) {
            int r = cells.get (i)[0] - 1;
            int c = cells.get(i)[1] - 1;
            grid[r][c] = 1;

        }
        // now we have to go from top to bottom weather it go or not
        for (int j = 0; j < COL; j++) {
            if (grid[0][j] == 0 && dfs(grid, 0, j)) {
                return true;
            }

        }
        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        ROW = row;
        COL = col;
        List<int[]> celllist = new ArrayList<>();
        for (int[] cell : cells) {
            celllist.add(cell);

        }
        int lastDay = 0;
        int l = 0;
        int r = cells.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (cancross(celllist, mid)) {
                lastDay = mid + 1;
                l = mid + 1;

            } else {
                r = mid - 1;
            }
        }
        return lastDay;
    }
}