class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> l = new ArrayList<>();
        l.add(-1);

        // int m[]=new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int m = Math.max(i - k, 0);
                int r = Math.min(i + k, n - 1);

                for (int j = m; j <= r; j++) {
                    if ((j > (l.get(l.size() - 1)))) {
                        l.add(j);
                    }
                }
            }

        }
        l.remove(0);
        return l;

    }
}