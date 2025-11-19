class Solution {
    public int findFinalValue(int[] nums, int original) {

        Arrays.sort(nums);

        int o = original;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == o) {
                o = 2 * o;

            }

        }

        return o;
    }
}