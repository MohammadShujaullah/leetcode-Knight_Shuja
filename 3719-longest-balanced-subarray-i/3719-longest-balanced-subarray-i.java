class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;

        if (n <= 1) {
            return 0;
        }

        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> st = new HashSet<>();
            int j = i;
            int counte = 0;
            int counto = 0;
            while (j >= i && j < n) {
                if (!st.contains(nums[j]) && nums[j] % 2 == 0) {
                    st.add(nums[j]);
                    counte++;

                } else if (!st.contains(nums[j]) && nums[j] % 2 == 1) {
                    st.add(nums[j]);
                    counto++;

                }
                if (counte == counto) {
                    max = Math.max(max, j - i+1);

                }

                j++;
            }

        }

        return max;
    }
}