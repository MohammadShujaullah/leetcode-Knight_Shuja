class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        // Arrays.sort(nums);
        // int curr = nums[0];
        // if (nums.length == 1)
        //     return nums[0];
        // int max = Integer.MIN_VALUE;
        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i] != nums[i - 1]) {
        //         curr += nums[i];
        //     }

        //     max = Math.max(max, curr);
        // }

        // return max;

        int windowstart=0;
        int windowend=0;                         // varible length sliding window apply here 
        int maxsum=Integer.MIN_VALUE;
        HashMap<Integer,Integer>mp=new HashMap<>();

        while(windowend<nums.length){
            int n=nums[windowend];
            int currsum=0;

            if(mp.containsKey(n) && mp.get(n)>=windowstart){
                windowstart=mp.get(n)+1;
            }

            mp.put(n,windowend);
           for(int i=windowstart;i<=windowend;i++){
            currsum+=nums[i];
           }


            maxsum=Math.max(maxsum,currsum);
            windowend++;
        }

         return maxsum==Integer.MIN_VALUE?0:maxsum;
      
    }
}