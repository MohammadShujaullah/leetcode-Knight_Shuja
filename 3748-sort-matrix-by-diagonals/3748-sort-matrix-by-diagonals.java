class Solution {
    private void sortDiagonal(int[][] grid, int row, int col, boolean ascending) {
        List<Integer> diagonal = new ArrayList<>();
        int i = row, j = col;
        int n = grid.length;

        // Extract the diagonal elements
        while (i < n && j < n) {
            diagonal.add(grid[i][j]);
            i++;
            j++;
        }

        // Sort the diagonal in the required order
        if (ascending) {
            Collections.sort(diagonal);
        } else {
            diagonal.sort(Collections.reverseOrder());
        }

        // Place back the sorted elements
        i = row;
        j = col;
        int index = 0;
        while (i < n && j < n) {
            grid[i][j] = diagonal.get(index++);
            i++;
            j++;
        }
    }

    public int[][] sortMatrix(int[][] grid) {

        int n = grid.length;

        // Sort bottom-left diagonals (including the main diagonal) in non-increasing
        // order
        for (int i = 0; i < n; i++) {
            sortDiagonal(grid, i, 0, false);
        }
        for (int j = 1; j < n; j++) {
            sortDiagonal(grid, 0, j, true);
        }
        return grid;
    }

}