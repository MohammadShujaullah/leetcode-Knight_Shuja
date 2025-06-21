class Solution {
    public int partitionArray(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);  //  time complexity  --O(log(n))

       int count=0;
       int minval=nums[0];

       for(int i=0;i<n;i++){
            if(Math.abs(nums[i]-minval)>k){
                count++;
                minval=nums[i];
            }
       }


       return count+1;   // for last subsequesnce


    }
}