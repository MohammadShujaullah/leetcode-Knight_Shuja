class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;

      int leftmax[]=new int [n];
      int rightmax[]=new int[n];

     long result=0;

///populate the arrays
      leftmax[0]=0;
      rightmax[n-1]=0;

      for(int i=1;i<n;i++){
        leftmax[i]=Math.max(leftmax[i-1],nums[i-1]);

      }
       for(int i=n-2;i>=0;i--){
        rightmax[i]=Math.max(rightmax[i+1],nums[i+1]);

      }

      for(int j=1;j<n;j++){
        result=Math.max(result,(long)(leftmax[j]-nums[j])*rightmax[j]);

      }

      return result;


      
      

    }
}