class Solution {
    public int findNumbers(int[] nums) {
       int result=0;
       for(int i=0;i<nums.length;i++){
        if((nums[i]>10 && nums[i]<99) || (nums[i]>999 && nums[i]<10000) || nums[i]==100000){
            result++;
        }
       } 

       return result;
    }
}