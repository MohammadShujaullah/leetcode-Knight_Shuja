class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length==1){
            return true;
        }

        for(int i=0;i<nums.length-1;i++){
            int x=nums[i];
            int y=nums[i+1];
            if(x%2!=0 && y%2!=0 || x%2==0 && y%2==0){
                return false;
            }
        }
        return true;
    }
}