class Solution {
    public int waysToSplitArray(int[] nums) {
        int count = 0;
        long Tsum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            Tsum += nums[i];
        }
        long sum =0;
        long another = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += nums[i];
            another = Tsum - sum;
            if (sum >= another) {
                count++;
            }

        }
        return count;
    }
}