class Solution {
    // in this question you just have to maintain the min. row and col.)  and (max.Row,max.col)
    // and the length (maxrow-minrow+1)  and breadth is (Maxcol-mincol+1)
    public int minimumArea(int[][] grid) {
        int minrow=grid.length;
        int mincol=grid[0].length;

        int maxcol=-1;
        int maxrow=-1;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    minrow=Math.min(minrow,i);
                    maxrow=Math.max(maxrow,i);

                    maxcol=Math.max(maxcol,j);
                    mincol=Math.min(mincol,j);

                }
            }
        }

        return (maxcol-mincol+1)*(maxrow-minrow+1);
        
    }
}