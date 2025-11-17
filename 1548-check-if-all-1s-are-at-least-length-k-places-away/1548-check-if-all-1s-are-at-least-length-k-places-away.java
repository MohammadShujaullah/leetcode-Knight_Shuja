class Solution {
    public boolean kLengthApart(int[] nums, int k) { 
        int n = nums.length;
        boolean onesee=false;

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count++;

            } else {
                if (count < k && i > 0 && onesee) {
                    return false;
                }
                onesee=true;
                count = 0;

            }
        }

        return true;
    }
}