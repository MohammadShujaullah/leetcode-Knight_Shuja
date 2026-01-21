class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
          int ans[] = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {

            int x = 1;
            int smallest = Integer.MAX_VALUE;

            while (x <= nums.get(i)) {
                if ((x | (x + 1)) == nums.get(i)) {

                    smallest = Math.min(smallest, x);

                    ans[i] = smallest;

                }
                x++;

            }

            if (ans[i] == 0) {
                ans[i] = -1;

            }

        }

        return ans;
    }
    
}