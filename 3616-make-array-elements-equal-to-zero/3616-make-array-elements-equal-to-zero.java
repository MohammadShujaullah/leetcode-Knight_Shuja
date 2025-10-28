class Solution {

     private boolean isValid(int[] nums, int count, int i, int direction) {
        int[] temp = nums.clone();
        int idx = i;

        while (count > 0 && idx >= 0 && idx < temp.length) {
            if (temp[idx] > 0) {
                temp[idx]--;
                direction *= -1;
                if (temp[idx] == 0) {
                    count--;
                }
            }
            idx += direction;
        }

        return count == 0; // all elements become 0
    }
    public int countValidSelections(int[] nums) {
       int n = nums.length;
        int result = 0;
        int count = 0;

        for (int num : nums) {
            if (num != 0) count++;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (isValid(nums, count, i, -1)) result++;
                if (isValid(nums, count, i, 1)) result++;
            }
        }

        return result;


    }
}