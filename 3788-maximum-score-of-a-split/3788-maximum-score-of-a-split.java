class Solution {
    public long maximumScore(int[] nums) {
        int n=nums.length;

        int suff[]=new int[n];
         suff[n-1]=nums[n-1];


        for(int i=n-2;i>=0;i--){
            suff[i]=Math.min(nums[i],suff[i+1]);
            
        }


        long  prefsum=0;

        long maxscore=Integer.MIN_VALUE;

        for(int i=0;i<n-1;i++){
            prefsum+=nums[i];

            long score=prefsum-suff[i+1];
            maxscore=Math.max(maxscore,score);
            
        }

        return maxscore;
    }
}