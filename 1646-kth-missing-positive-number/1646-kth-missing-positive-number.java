class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        // comparing the given array with ,original array
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int missing = arr[mid] - (mid + 1); // how maeny element is missing
            if (missing < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return l+k;   ///as the no. of element at left side present (l) and 
                        //the no of element which is missing (k) 

    }
}