class Solution {
    public boolean divideArray(int[] nums) {
        int XOR = 0;
        for (int i = 0; i < nums.length; i++) {
            XOR = XOR ^ nums[i];

        }
        if (XOR != 0) {
            return false;
        }

        // but the XOR condition is only check if the elements are pairs and as well as
        // like [1,2,3] the XOR of 1,2,3 are also zero , which is not correct for this
        // question

        // but if XOR IS not zero then , definatly the no. are not in pair

        // so we have to check for when XOR of numbers is zero

        int freq[] = new int[501]; // you have to store the freq of all number
        for (int m : nums) {

            freq[m]++;
        }

        // now checking the frequency of alll numbers

        for (int count : freq) {
            if (count % 2 != 0) {
                return false;
            }
        }
        return true;

    }
}