class Solution {
    public int minimumCost(int[] nums) {

        if (nums.length < 3) {
            return 0;

        }
        int min = nums[0]; // first element is always a starting point of any subarray

        int selr = Integer.MAX_VALUE;
        int lar = Integer.MAX_VALUE;
        int i = 1;

        while (i < nums.length) {
            if (nums[i] < lar) {
                selr = lar;
                lar = nums[i];

            } else if (nums[i] >= lar && nums[i] < selr) {
                selr = nums[i];
            }

            i++;

        }
        min += lar + selr;

        return min;

    }
}