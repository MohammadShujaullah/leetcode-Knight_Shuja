class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int prev=0;
        int curr=1;

        int ans=Integer.MIN_VALUE;


        for(int i=1;i<nums.size();i++){

            if(nums.get(i)>nums.get(i-1)){
                curr++;

            }
            else{
                prev=curr;
                curr=1;

            }


            ans=Math.max(ans,curr/2);

            ans=Math.max(ans,Math.min(prev,curr));





        }


        return ans;
    }
}