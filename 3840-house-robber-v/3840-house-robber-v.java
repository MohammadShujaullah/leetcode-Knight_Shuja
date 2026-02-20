class Solution {
    public long rob(int[] nums, int[] colors) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        long prev2 = 0;
        long prev1 = nums[0];
        long ans = prev1;

        for (int i = 1; i < n; i++) {

            long skip=prev1;
            
            long take = nums[i];

            if(colors[i]==colors[i-1]){
                take+=prev2;
                
            }
            else{
                take+=prev1;
                
            }


            long curr=Math.max(take,skip);
            prev2=prev1;
            prev1=curr;
            

            // take = Math.max(take, nums[i] + prev2);
            // if (colors[i] != colors[i - 1]) {
            //     take = Math.max(take, nums[i] + prev1);

            // }

            // ans = Math.max(ans, take);

            // prev2 = prev1;
            // prev1 = take;
        }

        return prev1;
    }

}