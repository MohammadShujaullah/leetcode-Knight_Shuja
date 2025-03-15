class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;

    }
}

class Solution {
    

    private boolean isSafe(int[][] grid, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

    public int orangesRotting(int[][] grid) {
     int [][]directions = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };


        int n=grid.length;
        int m=grid[0].length;
        
        int totalFresh=0;
        Queue<Node>q= new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Node(i,j));

                }
                else if(grid[i][j]==1){
                    totalFresh++;

                }
            }
        }

        if(totalFresh==0){    // already no fresh oranges present their
            return 0;

        }

        int minutes=0;
        while(!q.isEmpty()){

            int N=q.size();
            while(N-->0){
                Node nod= q.poll();

                int i=nod.x;       // these sre the co ordinates
                int j=nod.y;

                for(int []dir:directions){
                    int new_x=i+dir[0];
                    int new_y=j+dir[1];

                    if(isSafe(grid,new_x,new_y)  && grid[new_x][new_y]==1){
                        grid[new_x][new_y]=2;
                        totalFresh--;

                        q.add(new Node(new_x,new_y));


                    }
                }
            

            }
          minutes++;
        }
           return totalFresh==0?(minutes-1):-1;     // RETURNING THE minutes-1     ,is ******

    }
}