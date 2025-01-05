// search the target in two partitioned array, 
//partition by pivoted element or smallest 
//then apply binary search in both side of array partion by index of smallest element of array

class Solution {
    private int searchPivote(int[] nums, int n) {
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;

            } else {
                r = mid - 1;
            }
        }
        return -1;

    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivoted_el = searchPivote(nums, n);
        int idx = binarySearch(nums, 0, pivoted_el - 1, target);
        if (idx != -1) {
            return idx;
        }else{
            return binarySearch(nums, pivoted_el,n-1, target);
        }
    }
}
