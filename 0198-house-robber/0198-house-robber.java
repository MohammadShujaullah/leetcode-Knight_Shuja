class Solution {
    // without memoization ,the code giving me TLE,so use Memo
    int t[];

    private int solve(int[] nums, int i, int n) {
        if (i >= nums.length) {
            return 0;
        }

        if (t[i] != -1)
            return t[i];

        int steal = nums[i] + solve(nums, i + 2, n);
        int skip = solve(nums, i + 1, n);

        return t[i] = Math.max(steal, skip);

    }

    public int rob(int[] nums) {
      int n=nums.length;                         // memo is always generally same 

      t=new int [n+1];
      Arrays.fill(t,-1);

      return solve(nums,0,n);
    }
}