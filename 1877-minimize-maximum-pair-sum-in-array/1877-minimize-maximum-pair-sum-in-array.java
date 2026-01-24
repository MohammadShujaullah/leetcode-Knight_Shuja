class Solution {
    public int minPairSum(int[] nums) {

        int n = nums.length;

        Arrays.sort(nums);
        int j = n-1;

        int max = 0;

        for (int i = 0; i < n / 2; i++) {

            int sum = (nums[i] + nums[j]);
            max = Math.max(sum, max);

            j--;
        }

        return max;
    }
}