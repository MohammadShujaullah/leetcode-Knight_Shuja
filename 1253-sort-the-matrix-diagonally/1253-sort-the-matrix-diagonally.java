class Solution {
    public int[][] diagonalSort(int[][] mat) {
        //when we have to traverse along diagonal of 2D matrix , we have two option [i+j] or [i-j]
        int m=mat.length;
        int n=mat[0].length;

        HashMap<Integer,ArrayList<Integer>>mp= new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){   // according to question we have to use [i-j]
                if(!mp.containsKey(i-j)){
                    mp.put(i-j,new ArrayList<>());
                }
                mp.get(i-j).add(mat[i][j]);
            }
            
        }
        for(ArrayList<Integer>list:mp.values()){
             Collections.sort(list);

        }
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){   // according to question we have to use [i-j]
                 mat[i][j]=mp.get(i-j).remove(mp.get(i-j).size()-1);
            }
            
        }

   return mat;

    }
}