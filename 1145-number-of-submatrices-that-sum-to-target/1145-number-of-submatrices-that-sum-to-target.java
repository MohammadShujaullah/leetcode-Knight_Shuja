class Solution {

    // to make optimise solution we hove to do an observation , that is --> you just have to find cummulative sum of every row , in the matrix 

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;

        // now finding the cummulative sum
        for(int row=0;row<rows;row++){
            for(int col=1;col<cols;col++){
                matrix[row][col]+=matrix[row][col-1];
            }
        }

        // now u need to find the no. ofd subarray  with sum==target(leetcode 560- Downwards)

        int result=0;
        for(int startcol=0;startcol<cols;startcol++){
            for(int j=startcol;j<cols;j++){
                Map<Integer,Integer>mp=new HashMap<>();
                mp.put(0,1);
                int cumsum=0;
                for(int row=0;row<rows;row++){
                     cumsum+=matrix[row][j]-(startcol>0?matrix[row][startcol-1]:0);
                    if(mp.containsKey(cumsum-target)){
                        result+=mp.get(cumsum-target);

                    }   
                    
                        mp.put(cumsum,mp.getOrDefault(cumsum,0)+1);
 

             }
            }

        }

        return result;
    }
}