class Solution {
    public int minimumOperations(int[] nums) {
        int n=nums.length;
        int op=0;
        for(int i=0;i<n;i++){
            if(nums[i]%3>1){
                op+=(3-nums[i]%3);
                
            }else{
          op+=nums[i]%3;

            }

        }

        return op;
    }
}