class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int prev = 0;
        int curr = 1;

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                curr++;

                if (curr / 2 >= k) {
                    return true;
                }

            }

            else {
                prev = curr;
                curr = 1;
            }

            if (prev / 2 >= k)
                return true;

            if (Math.min(prev, curr) >= k) {
                return true;
            }

        }

        return false;
    }
}
