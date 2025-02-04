class Solution {
    public int maxAscendingSum(int[] nums) {
        int n=nums.length;
        int sum=nums[0];
        int maxsum=sum;
        for(int i=1;i<n;i++){
             if(nums[i]>nums[i-1]){
                  sum+=nums[i];
                  
             }
            else{
                sum=0;
                sum+=nums[i];
            }
            maxsum=Math.max(sum,maxsum);

        }
        return maxsum;
    }
}