class Solution {
    int DP[][];
    int n;

    private int solve(List<Integer> nums, int idx, int target) {

        if (target == 0)
            return 0;
        if (target < 0 || idx >= n)
            return Integer.MIN_VALUE;

        if (DP[idx][target] != -1)
            return DP[idx][target];

        int take = 1 + solve(nums, idx + 1, target - nums.get(idx));

        int skip = solve(nums, idx + 1, target);

        return DP[idx][target] = Math.max(skip, take);

    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        n = nums.size();
        DP = new int[n + 1][target + 1];
        for (int row[] : DP) {
            Arrays.fill(row, -1);
        }

        int ans = solve(nums, 0, target);
        if (ans <= 0)
            return -1;

        return ans;
    }
}