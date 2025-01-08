/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

class Solution {
    private int peakindex(MountainArray mountainArr) {
        int l = 0;
        int r = mountainArr.length() - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;

    }

    private int binarySearchAccending(int target, int l, int r, MountainArray mountainArr) {

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return -1;
    }

    private int binarySearchDecending(int target, int l, int r, MountainArray mountainArr) {

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) < target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakidx = peakindex(mountainArr);
        int found = binarySearchAccending(target, 0, peakidx - 1, mountainArr);
        if (found != -1) {
            return found;
        }
        return binarySearchDecending(target, peakidx, mountainArr.length() - 1, mountainArr);

    }
}