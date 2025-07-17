class Solution {

    public int maximumLength(int[] nums, int k) {
        int n = nums.length;

        int DP[][] = new int[n][k];

        for (int row[]: DP) {
            Arrays.fill(row, 1);
        }

        int max1 = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int mod = (nums[i] + nums[j]) % k;

                DP[i][mod] = Math.max(DP[i][mod], DP[j][mod] + 1);
                max1 = Math.max(max1, DP[i][mod]);

            }
        }

        return max1;

    }
}