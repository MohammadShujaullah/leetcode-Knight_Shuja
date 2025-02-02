class Solution {

    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            // if the current element is less than
            // the previous element,means it is an inversion
            if (nums[i] > nums[i + 1]) {
                count++;
            }
            // we have atleast one peak , very compulsary so, we have to
            // check the boundary condition between the firsrt and the ladt element

        }
        if (nums[0] < nums[n - 1]) {
            count++;
        }
        if (count > 1) {
            return false;
        }
        return true;
    }
}