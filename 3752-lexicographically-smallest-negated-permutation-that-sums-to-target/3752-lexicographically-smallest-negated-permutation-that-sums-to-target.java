class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long positiveSum=(long)n*(n+1)/2;

        if(Math.abs(target)>positiveSum){
            return new int [0];
            
        }

        int arr[]=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }

        long currentSum=positiveSum;

        long diff=currentSum-target;


        for(int i=n;i>=1 && diff>0;i--){
            if(diff>=2L*i){
                arr[i-1]=-i;
                diff-=2L*i;
                
            }
        }

        if(diff!=0){
            return new int[0];
            
        }
        Arrays.sort(arr);
        return arr;
        
    }
}