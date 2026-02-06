class Solution {

    private int lisLength(List<Integer> l) {

        List<Integer> dp = new ArrayList<>();

        for (int x : l) {
            int idx = Collections.binarySearch(dp, x);

            if (idx < 0) {
                idx = -idx - 1;

            }

            if (idx == dp.size())
                dp.add(x);
            else
                dp.set(idx, x);

        }

        return dp.size();

    }

    public int longestSubsequence(int[] nums) {
        int ans = 0;

        for (int i = 0; i < 31; i++) {
            List<Integer> l = new ArrayList<>();
            for (int num : nums) {
                if ((num & (1 << i)) != 0) {
                    l.add(num);
                }
            }

            ans = Math.max(ans, lisLength(l));

        }

        return ans;

    }
}