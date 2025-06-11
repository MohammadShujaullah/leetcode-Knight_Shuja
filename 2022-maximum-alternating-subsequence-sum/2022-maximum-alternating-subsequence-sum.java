class Solution {
    int n;
    long t[][];

    private long solve(int idx, int[] nums, boolean flag) {
        if (idx >= n)
            return 0;

        int f = flag ? 1 : 0;

        if (t[idx][f] != 0) {
            return t[idx][f];
        }
        long skip = solve(idx + 1, nums, flag);// when you are skipping, then no addition of val 

        int val = nums[idx];
        if (flag == false) {
            val = -val;
        }

        long take = solve(idx + 1, nums, !flag) + val;

        return t[idx][f] = Math.max(take, skip);

    }

    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        t = new long[n][2];

        return solve(0, nums, true);// 0 means even index, and treu means '+'
    }
}