class Solution {
    public int maxSum(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int currsum = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i]) && nums[i] >= 0) {
                set.add(nums[i]);
                currsum += nums[i];
                ans = Math.max(ans, currsum);

            } 
            else if (nums[i] < 0) {     // this is fro when array contains only negative element or some negative element in the array
    
                ans = Math.max(ans, nums[i]);

            } 
            else {     // ismain sirf whi case ayega, jo element set main  already han
                currsum-=nums[i];
                currsum += nums[i];      // thses two lines is only for understanding that ,that we remove duplicate and then again add the new one 
                 ans = Math.max(ans, currsum);
            }
        }
        return ans;

    }
}