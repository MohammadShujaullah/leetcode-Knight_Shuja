class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = 0;
        int count = 0;
        int maxcount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];

            }
        }

        int i = 0;
        int j = 0;
        while (j < n) {
            if (nums[j] == max) {
                count++;
                maxcount = Math.max(count, maxcount);

            }
            else{
                count=0;
            }
            j++;
        }
        return maxcount;
    }
}