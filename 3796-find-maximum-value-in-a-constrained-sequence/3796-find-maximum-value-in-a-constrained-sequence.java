class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        long INF=(long)1e18;

        long[]limit=new long[n];


        for(int i =0;i<n;i++){
            limit[i]=INF;
            
        }

        limit[0]=0;


        for(int []r:restrictions){
            limit[r[0]]=Math.min(limit[r[0]],r[1]);
            
        }
         for(int i =1;i<n;i++){
            limit[i]=Math.min(limit[i],limit[i-1]+diff[i-1]);

            
        }

         for(int i =n-2;i>=0;i--){
            limit[i]=Math.min(limit[i],limit[i+1]+diff[i]);

            
        }

        long ans=0;

        for(long v:limit) ans=Math.max(ans,v);


        return (int)ans;

        
        
    }
}