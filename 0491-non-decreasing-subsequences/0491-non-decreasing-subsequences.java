class Solution {
    int n;

    private void backTrack(int nums[], int idx, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() >= 2) {
            result.add(new ArrayList<>(curr));

        }
        Set<Integer> set = new HashSet<>();

        for (int i = idx; i < n; i++) {
            if ((curr.isEmpty() || nums[i] >= curr.get(curr.size() - 1)) && !set.contains(nums[i])) {

                set.add(nums[i]); // mark number as used in this layer

                curr.add(nums[i]);
                backTrack(nums, i + 1, curr, result);
                curr.remove(curr.size() - 1);

            }
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backTrack(nums, 0, curr, result);

        return result;

    }
}