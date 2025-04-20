// when the questiion ask about the shortest path , you shoold always think about BfS

class Node {
    int p;
    int q;

    public Node(int p, int q) {
        this.p = p;
        this.q = q;

    }
}

class Solution {

    private boolean isSafe(char[][] maze, int x, int y) {
        int n = maze.length;
        int m = maze[0].length;
        return (x >= 0 && x < n && y >= 0 && y < m);

    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int n=maze.length;
        int m=maze[0].length;


        // the entrance , must not be the exit ,
        int dir[][]={{1,0},{-1,0},{0,-1},{0,1}};


        Queue<Node>q=new LinkedList<>();

        q.add(new Node(entrance[0],entrance[1]));

        //also makr visited  ,by putting as '+'
        maze[entrance[0]][ entrance[1]]='+';


       int step=0;

        while(!q.isEmpty()){

            int N=q.size();

            while(N-->0){
                Node temp= q.remove();

                int i=temp.p;
                int j=temp.q;

                if((i!=entrance[0] || j!=entrance[1]) && 
               ( i==0|| i==n-1 ||j==0 ||j==m-1)){
                                return step;
                }

                // if i not reach the boundry yet

                for(int[] x:dir){

                    int x_=i+x[0];
                    int y_=j+x[1];

                    if(isSafe(maze,x_,y_) && maze[x_][y_]!='+'){
                        q.add(new Node(x_,y_));

                        maze[x_][y_]='+';

                    }


                }
    
            }

            step++;

        }

    return -1;

    }
}