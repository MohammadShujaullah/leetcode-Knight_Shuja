class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxx = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length-1; i++) {

           if(maxx<Math.abs(nums[i]-nums[i+1])){
            maxx=Math.abs(nums[i]-nums[i+1]);
           }

        }

        return Math.max(maxx, Math.abs(nums[0] - nums[n - 1]));
    }
}