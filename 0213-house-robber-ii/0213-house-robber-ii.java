//same as of house robber 1 
class Solution {
    int t[];

    private int solve(int nums[], int i, int n) {
        if (i > n)
            return 0;

        if (t[i] != -1)
            return t[i];

        int steal = nums[i] + solve(nums, i + 2, n);
        int skip = solve(nums, i + 1, n);

        return t[i] = Math.max(steal, skip);

    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        t = new int[n + 1];
        Arrays.fill(t, -1);
        // 1st is for ,
        // when 1st house is robbed , and second is for , when the 1st house is not robbed
        int case1 = solve(nums, 0, n - 2);
        Arrays.fill(t, -1);
        int case2 = solve(nums, 1, n - 1);
        //return Math.max(solve(nums, 0, n - 2), solve(nums, 1, n - 1));

        return Math.max(case1, case2);
    }
}