class Solution {


    private boolean check(int nums[],int k){

        long oper=0;

        long limit=(long)k*k;


        for(int num:nums){
            oper+=(num+k-1)/k;

            if(oper>limit){
                return false;
            }
        }

        return true;
        
    }
    public int minimumK(int[] nums) {
        int low=1;

        int high=100000;

        int ans=high;


        while(low<=high){
            int mid=low+(high-low)/2;


            if(check(nums,mid)){
                ans=mid;
                high=mid-1;
                
            }else{
                low=mid+1;
                
            }
        }

        return ans;
    }
}