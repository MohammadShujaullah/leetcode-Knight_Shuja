class Solution {
    public int singleNonDuplicate(int[] nums) {
       int m=0;
       for(int i=0;i<nums.length;i++){
           m=m^nums[i];

       }
       return m;
    }
}