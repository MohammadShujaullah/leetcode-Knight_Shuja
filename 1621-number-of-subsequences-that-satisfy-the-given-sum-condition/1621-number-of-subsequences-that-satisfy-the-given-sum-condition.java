class Solution {
    public int numSubseq(int[] nums, int target) {
        int count = 0;
        int n = nums.length;

        Arrays.sort(nums);

        final int MOD = (int) 1e9 + 7;

        int array[] = new int[n];
        array[0] = 1;
        for (int i = 1; i < n; i++) {
            array[i] = (array[i - 1] * 2) % MOD;
        }

        int l = 0;
        int r = n - 1;
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                count = (count % MOD + array[r - l] % MOD) % MOD; // agr rth number se milkr target se chota element bn ja rha to , it means rth ke left wale saare element se bhi mil kr target se kam bn skta ha , so we calculate all combination
                l++;
            } else {
                r--;
            }
        }

        return (count);
    }
}