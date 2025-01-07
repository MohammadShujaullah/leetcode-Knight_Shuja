class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;     // the mountain must be greater ,so l can start  with mid+1
            } else {
                r = mid;          // the moutain must be greater so ,we cannot neglect mid element ,so r stat with mid
            }
        }
        return l;
    }
}
