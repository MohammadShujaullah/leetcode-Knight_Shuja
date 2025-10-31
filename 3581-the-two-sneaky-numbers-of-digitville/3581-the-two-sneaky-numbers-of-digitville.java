class Solution {
    // making use of diffrent bit as separator
    // as i observer , taking XOR of 3 and 2 gives 01, 
    //means at 0th bit is set bit , pakka se 
    //ye tab aya hoga jab 2 and 3 ka 0th bit diffrent hoga

    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length - 2; // only 2 number is comming extra
        int XOR = 0;
        for (int num : nums) {
            XOR ^= num;
        }

        for (int num = 0; num <=n - 1; num++) {
            XOR ^= num;

        }

        // Find rightmost set bit (similar to __builtin_ctz in C++)
        int trailzerocount = Integer.numberOfTrailingZeros(XOR);
        int mask = 1 << trailzerocount;

        int G1 = 0;
        int G2 = 0;

        for (int num : nums) {
            if ((num & mask)!=0) {
                G1 ^= num;
            } else {
                G2 ^= num;
            }

        }
         for(int num=0;num<=n-1;num++){
            if ((num & mask)!=0) {
                G1 ^= num;
            } else {
                G2 ^= num;
            }

         }

         return new int[]{G1,G2};


    }
}