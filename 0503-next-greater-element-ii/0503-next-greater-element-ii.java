class Solution {

    /**WHENEVER there is circular arr, do nothing more! just create a newarr with size double 
    of the original arr and just copy the original arr twice in the newarr, so we can do the 
    circular arr traversal in single loop, no back pointer, EASY! this question can be easily 
    solved without stack, by the above-mentioned approach! */
    
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int ans[]=new int [n];
        Arrays.fill(ans,Integer.MIN_VALUE);


        for(int i=0;i<n;i++){
            for(int j=i+1;j<=i+n-1;j++){
                if(nums[i]<nums[j%n]){
                    ans[i]=nums[j%n];
                    break;
                }
            }
            if(ans[i]==Integer.MIN_VALUE){
                ans[i]=-1;
            }
        }

        return ans;

    }
}