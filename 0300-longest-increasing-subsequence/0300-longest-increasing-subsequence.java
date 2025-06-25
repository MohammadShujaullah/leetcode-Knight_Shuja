class Solution {
    int t[][];

    private int solve(int p, int idx, int nums[]) {
        if (idx >= nums.length)
            return 0;

        int skip = 0;
        int take = 0;
        if ( p!=-1 && t[idx][p] != -1) // after memoization the time reduce from O(2^n) to O(n^2)
            return t[idx][p];
        if (p == -1 || nums[p] < nums[idx]) {

            take = solve(idx, idx + 1, nums) + 1;
        }
        skip = solve(p, idx + 1, nums);
        if(p!=-1){
            t[idx][p] = Math.max(skip, take);
        }

        return Math.max(skip, take);

    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        t = new int[n + 1][n + 1];
        for (int[] row : t)
            Arrays.fill(row, -1);

        return solve(-1, 0, nums); // p is the previous index
    }
}