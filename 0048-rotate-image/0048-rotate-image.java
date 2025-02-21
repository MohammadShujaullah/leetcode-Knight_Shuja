class Solution {
    public void rotate(int[][] matrix) {
        int m=matrix.length;
        int n=m;
        for(int i=0;i<m;i++){
            for(int j=i;j<m;j++){
            // taking the transpose of the matrix
            int temp=matrix[i][j];
           matrix[i][j]= matrix[j][i];
            matrix[j][i]=temp;

            }
        }

        // now reversing the each row
        for(int i=0;i<m;i++){
            int start=0;
            int end=m-1;
            while(start<end){
               int comp=matrix[i][start];
            matrix[i][start]=matrix[i][end];
            matrix[i][end]=comp;

            start++;
            end--;
            }
           
        }
    }
}