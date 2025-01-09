class Solution {
    public boolean validMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        if (arr.length < 3)
            return false;
        int peaks = 0;
        for (int i = 1; i < arr.length - 1; i++) { // to check the previous and last element the satrt of i and end is
                                                   // 1,arr.length-1
            int prev = arr[i - 1];
            int curr = arr[i];
            int next = arr[i + 1];

            if (prev==curr || curr == next) {
                return false;
            }
            if (prev>curr && curr < next) { // no vally should be occurs
                return false;
            }
            if (prev<curr && curr > next) {
                peaks++;
                if (peaks > 1) { // only one peak allowed and also zero peak is not allowed
                    return false;
                }
            }
        }
        return peaks==1;

        // Peak cannot be at the start or end

    }
}