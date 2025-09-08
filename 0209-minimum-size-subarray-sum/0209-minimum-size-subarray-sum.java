class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       // this question based on variable window size 
        // int windowstart=0;
        // int windowend=0;
        // int sum=0;
        // int minlen=Integer.MAX_VALUE;
        // int len=0;
        // while(windowend<nums.length){
        //         //expansion
        //     sum+=nums[windowend];

        //     if(sum>=target){
        //         len=windowend-windowstart+1;
        //         minlen=Math.min( minlen,len);

        //         //shrinking the window size by changing windowstart
        //         while(windowstart<windowend && sum>=target){
        //             sum-=nums[windowstart];
        //             windowstart++;
        //             if(sum>=target){
        //                 len=windowend-windowstart+1;
        //                 minlen=Math.min( minlen,len);
        //             }
        //         }
        //     }
        //     windowend++;

        // }
        // return(minlen==Integer.MAX_VALUE)?0:minlen;

        int i = 0;
        int j = 0;
        int sum = 0;
        int minlen = Integer.MAX_VALUE;
        int len = 0;

        while (j < nums.length) {
            sum += nums[j];

            

            while ( sum >= target) {
                   minlen = Math.min(minlen, j-i+1);

                sum -= nums[i];
                i++;
                
                      
                 
           

            }
            j++;
        }
        return (minlen == Integer.MAX_VALUE ? 0 : minlen);

    }
}