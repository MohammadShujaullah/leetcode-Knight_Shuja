class Solution {

    private boolean isMagicGrid(int[][] grid, int i, int j) {
     
        //element should be distinct ,and >9
        Set<Integer>set=new HashSet<>();



        
        
        for (int x = i; x < i + 3; x++) {

            for (int y = j; y < j + 3; y++) {

               if(grid[x][y]>9 ||grid[x][y]<1|| set.contains(grid[x][y])){
                return false;
               }
               else{
                set.add(grid[x][y]);
                
               }
            }
        }
           int Rsum = grid[i][j]+grid[i][j+1]+grid[i][j+2];
           


           for(int x=0;x<3;x++){
                   if((grid[x+i][j]+grid[x+i][j+1]+grid[x+i][j+2])!=Rsum){
                    return false;
                   }
                    if((grid[i][j+x]+grid[i+1][j+x]+grid[i+2][j+x])!=Rsum){
                return false;
            }
           }
 


          
            if((grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2])!=Rsum){
                return false;
            }
                if((grid[i][j+2]+grid[i+1][j+1]+grid[i+2][j])!=Rsum){
                return false;
            }
                    
        return true;

    }

    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int count = 0;

        for (int i = 0; i <= row - 3; i++) {
            for (int j = 0; j <= col - 3; j++) {
                if (isMagicGrid(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }
}