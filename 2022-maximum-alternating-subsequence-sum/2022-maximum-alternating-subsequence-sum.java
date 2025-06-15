class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long t[][] = new long[n+1][2]; // 0 for true and 1 for odd 

        for (int i = 1; i < n+1; i++) {
    
                t[i][0] = Math.max(t[i - 1][1] - nums[i-1], t[i - 1][0]); // if number add at even idx

                t[i][1] = Math.max(t[i - 1][0] + nums[i-1], t[i - 1][1]);//  for number at odd idx
            

        }

        return Math.max(t[n][0], t[n][1]);

    }
}