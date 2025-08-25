class Solution {
    // private void sortDiagonal(int[][] grid, int row, int col, boolean ascending) {
    //     List<Integer> diagonal = new ArrayList<>();
    //     int i = row, j = col;
    //     int n = grid.length;

    //     // Extract the diagonal elements
    //     while (i < n && j < n) {
    //         diagonal.add(grid[i][j]);
    //         i++;
    //         j++;
    //     }

    //     // Sort the diagonal in the required order
    //     if (ascending) {
    //         Collections.sort(diagonal);
    //     } else {
    //         diagonal.sort(Collections.reverseOrder());
    //     }

    //     // Place back the sorted elements
    //     i = row;
    //     j = col;
    //     int index = 0;
    //     while (i < n && j < n) {
    //         grid[i][j] = diagonal.get(index++);
    //         i++;
    //         j++;
    //     }
    // }

    // public int[][] sortMatrix(int[][] grid) {

    //     int n = grid.length;

    //     // Sort bottom-left diagonals (including the main diagonal) in non-increasing
    //     // order
    //     for (int i = 0; i < n; i++) {
    //         sortDiagonal(grid, i, 0, false);
    //     }
    //     for (int j = 1; j < n; j++) {
    //         sortDiagonal(grid, 0, j, true);
    //     }
    //     return grid;
    // }






    

    // same to same the question 
    public int[][] sortMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();

        // now i filling the hashaMAP

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!mp.containsKey(i - j)) {
                    mp.put(i - j, new ArrayList<>());

                }

                mp.get(i - j).add(grid[i][j]);

            }
        }

        // now sorting the whole values()

         //  sort each diagonal with correct order
    for (Map.Entry<Integer, ArrayList<Integer>> e : mp.entrySet()) {
        int key = e.getKey();
        ArrayList<Integer> list = e.getValue();

        if (key >= 0) {
            // bottom-left including main → descending
            list.sort(Collections.reverseOrder());
        } else {
            // top-right → ascending
            Collections.sort(list);
        }
    }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                ArrayList<Integer>lt= mp.get(i - j);
                grid[i][j] = lt.remove(0);

             
            }
        }

        return grid;
    }

}