
class Solution {
    private int sum(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

        }
        return sum;
    }

    public int minOperations(int[] nums, int k) {
        int count = 0;
        int sum = sum(nums);

        if (sum % k == 0)
            return count;

        return sum % k;

    }
}