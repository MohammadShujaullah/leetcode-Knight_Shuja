class Solution {
    public int countHillValley(int[] nums) {

        int count = 0;
        int i = 0;
        for (int j = 1; j < nums.length - 1; j++) {
            if ((nums[j] > nums[i] && nums[j] > nums[j + 1]) ||(nums[j] < nums[i] && nums[j] < nums[j + 1])) {
                //hill//valley
                count++;
                i=j;

            }

         
               
            
        }
        return count;
    }
}