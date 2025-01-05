class Solution {
    private int searchPivote(int[] nums, int n) {

        int l = 0;                     // SAME QUESTION NO.33 ,ONLY DIFFRENCE IS THE DUPLICATE ELEMENTS PRESENCE 
        int r = n - 1;                 /// TIME -->LOG(N)   SPACE-->O(1)

        while (l < r) {
            while (l < r && nums[l] == nums[l + 1]) {
                l++;
            }
            while (l < r && nums[r] == nums[r - 1]) {
                r--;
            }
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    private boolean binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                l = mid + 1;

            } else {
                r = mid - 1;
            }
        }
        return false;

    }

    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int pivoted_el = searchPivote(nums, n);
        if(binarySearch(nums, 0, pivoted_el - 1, target) ||binarySearch(nums, pivoted_el, n - 1, target)){
            return true;
        }
     
        return false;

    }
}
