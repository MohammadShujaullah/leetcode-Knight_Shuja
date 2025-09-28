class Solution {
    // missing number, method 1, using (sum of n term), used for not much big n 
    public int missingNumber(int[] nums) {

        int n=nums.length;
         int expectedsum=n*(n+1)/2;

         int actualsum=0;

         for(int i=0;i<nums.length;i++){
            actualsum+=nums[i];

         }


         return (expectedsum-actualsum);
         


    }
}