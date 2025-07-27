class Solution {
    public int maxSum(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int currsum = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i]) && nums[i] > 0) {
                set.add(nums[i]);
                currsum += nums[i];
                ans = Math.max(ans, currsum);

            } 
            else if (nums[i] < 0) {

                ans = Math.max(ans, nums[i]);

            } else {
                currsum-=nums[i];
                currsum += nums[i];
                 ans = Math.max(ans, currsum);
            }
        }
        return ans;

    }
}