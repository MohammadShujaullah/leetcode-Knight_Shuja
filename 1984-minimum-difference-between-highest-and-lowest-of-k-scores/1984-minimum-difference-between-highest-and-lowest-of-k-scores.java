class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        int j = k - 1; //sliding window 
        for (int i = 0; i < nums.length; i++) {

            if (j <= nums.length - 1) {
                min = Math.min(min, (nums[j] - nums[i]));
                j++;
            }

        }

        return min;
    }
}