class Solution {
    public int countPairs(int[] nums, int k) {
        int count=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
           for(int j=i+1;j<n;j++){
             if(nums[i]==nums[j]  && (i*j)%k==0){
               count++;
             
             }
           
           }
        
        }

        return count;
        
    }
}