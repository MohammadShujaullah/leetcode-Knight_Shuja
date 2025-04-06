class Solution {
    public boolean issafe(int row, int col, char[][] board) {
        int r = row; // for horizontal
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        // vertical
        for (int j = 0; j < board.length; j++) {
            if (board[j][col] == 'Q') {
                return false;
            }

        }
        // upper left

        for (int c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        } // upper right

        for (int c = col; r >= 0 && c < board.length; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }

        } // lower left 
         r=row;
        for (int c = col; r < board.length && c >= 0; r++, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        // lower rigth
        for (int c = col; r < board.length && c < board.length; r++, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public void Saveboard(char[][] board, List<List<String>> allboards) {
        String row = "";
        List<String> newboard = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            row = "";
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'Q') {
                    row += 'Q';
                } else
                    row += ".";

            }
            newboard.add(row);
        }
        allboards.add(newboard);
    }

    public void Helper(char[][] board, List<List<String>> allboards, int col) {

        if (col == board.length) {
            Saveboard(board, allboards);
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (issafe(row, col, board)) {
                board[row][col] = 'Q';
                Helper(board, allboards, col + 1);
                board[row][col] = '.';
            }

        }

    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allboards = new ArrayList<>();
        char[][] board = new char[n][n];
        Helper(board, allboards, 0);
        return allboards;
    }
}