class Spreadsheet {
    int[][] arr;

    public Spreadsheet(int rows) {
        arr = new int[rows][26];

    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        arr[row][col] = value;

    }

    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        arr[row][col] = 0;

    }

    private int solve(String x){
      
      if(Character.isDigit(x.charAt(0))){
        return Integer.parseInt(x);

      }
      
         int col = x.charAt(0) - 'A';
        int row = Integer.parseInt(x.substring(1)) - 1;
         return arr[row][col];





    }

    public int getValue(String formula) {
         String s=formula.substring(1);

         int plusidx=s.indexOf('+');

         String left= s.substring(0,plusidx);
         String right=s.substring(plusidx+1);


         return solve(left)+solve(right);


    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */