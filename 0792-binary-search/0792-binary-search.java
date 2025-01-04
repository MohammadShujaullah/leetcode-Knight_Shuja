// we can solve this problem by iterative as well as recursive
// iterative is very comman ,so we sovle by reccussion

class Solution {
    public int solve(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return solve(nums, mid + 1, r, target);   // time complexity is LOG(n)  /// space complexity is O(1)
        } else {
            return solve(nums, l, mid - 1, target);
        }

    }

    public int search(int[] nums, int target) {
        int n=nums.length;
        return solve(nums,0,n-1,target);

    }
}
