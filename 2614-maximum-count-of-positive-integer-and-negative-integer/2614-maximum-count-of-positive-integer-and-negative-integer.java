class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        int maxans = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                neg++;
            } else if (nums[i] > 0) {
                pos++;
            } else {
                continue;
            }
        }
        maxans = Math.max(pos, neg);
        return maxans;

    }
}