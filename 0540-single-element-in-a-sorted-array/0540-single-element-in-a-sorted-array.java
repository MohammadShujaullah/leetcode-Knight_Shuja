class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;

            // finding that right side has even or odd no. of element
            boolean isEven;
            if ((r - mid) % 2 == 0) {
                isEven = true;
            } else {
                isEven = false;
            }

            // checking that adjacent element is equal or not
            if (nums[mid] == nums[mid + 1]) {
                if (isEven) {
                    l = mid + 2; // answer may be at right side

                } else {
                    r = mid - 1;
                }

            } else { // (nums[mid]==nums[mid+1])
                if (isEven) {
                    r = mid; // answer may be at right side

                } else {
                    l = mid + 1;
                    ;
                }

            }
        }
        return nums[r];

    }
}