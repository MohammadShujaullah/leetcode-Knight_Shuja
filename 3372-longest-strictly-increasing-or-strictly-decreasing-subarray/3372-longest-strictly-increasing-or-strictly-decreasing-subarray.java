import java.lang.Math;

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int inccount = 0;
        int deccount = 0;
        int ans = 1;
        for (int i = 0; i < n - 1; i++) {

            if (nums[i] < nums[i + 1]) {
                if (inccount == 0) {
                    inccount = 2;
                } else {
                    inccount++;
                }
                ans = Math.max(ans, inccount);
                deccount = 0; // you nhave to0 make the decrerasing array count=0

            } else if (nums[i] > nums[i + 1]) {
                if (deccount == 0) {
                    deccount = 2;
                } else {
                    deccount++;
                }
                ans = Math.max(ans, deccount);
                inccount = 0; // you nhave to0 make the increrasing array count=0

            }

            else {
                deccount = 0;
                inccount = 0;
            }

        }
        return ans;
    }
}