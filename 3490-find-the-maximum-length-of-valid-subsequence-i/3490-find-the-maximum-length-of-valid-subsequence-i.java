class Solution {
    // there are two cases one is for ()%2==0  or ()%2==1
    // so we have to call the LIS function two times ,one for ()%2==1,2nd for ()%2==0.  

    // int n;
    // int DP[][];

    // private int solve(int p, int idx, int[] nums, int target) {
    //     if (idx >= n)
    //         return 0;
    //     if (DP[idx][p + 1] != -1)
    //         return DP[idx][p + 1];

    //     int take = 0;

    //     if (p == -1 || (nums[p] + nums[idx]) % 2 == target) {
    //         take = 1 + solve(idx, idx + 1, nums, target);
    //     }
    //     int skip = solve(p, idx + 1, nums, target);
    //     if (p != -1) {
    //         DP[idx][p + 1] = Math.max(take, skip);
    //     }

    //     return Math.max(take, skip);
    // }

    // public int maximumLength(int[] nums) {

    //     n = nums.length;

    //     DP = new int[n + 1][n + 1];
    //     for (int row[] : DP) {
    //         Arrays.fill(row, -1);
    //     }

    //     int remainerEven = solve(-1, 0, nums, 0); // last wala zero  ye indicate kr rha ha, ()%2==0 

    //     for (int row[] : DP) {
    //         Arrays.fill(row, -1);
    //     }

    //     int remainerOdd = solve(-1, 0, nums, 1); // last wala one  ye indicate kr rha ha, ()%2==1

    //     return Math.max(remainerEven, remainerOdd);
    // }

    ////////////------------above code giving me MLE, even we used memoization------//////

    // private int Solve(int[] nums, int modulo[],int target) {
    //     int max1=1;

    //     for (int i = 1; i < nums.length; i++) {
    //         for (int j = 0; j < i; j++) {
    //             if ((nums[i] + nums[j]) % 2 == target) {
    //                 modulo[i] = Math.max(modulo[i], modulo[j] + 1);
    //                 max1 = Math.max(max1, modulo[i]);
    //             }

    //         }
    //     }
    //     return max1;
    // }

    // public int maximumLength(int[] nums) {

    //     int modulo[] = new int[nums.length];
    //     Arrays.fill(modulo, 1);

    //     int modulo1=Solve(nums,modulo,1);
    //      Arrays.fill(modulo, 1);
    //     int modulo2=Solve(nums,modulo,0);

    //     return Math.max(modulo1,modulo2);

    // }
    ////////////------------above code giving me TLE, even we used bottom up O(N^2)------//////

    public int maximumLength(int[] nums) {

        //there are 4 cases ,or 4 sinerios , if subsequence contains 1.only odd  ,2.only even, 3.alternate odd even ,4.alternate even odd

        // the last two cases are just same 

        int oddnum = 0;
        int evennum = 0;
        int alternum=1;    // 1st element is taken 

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) { // this made all even subsequence
                evennum++;
            } else if (nums[i] % 2 != 0) { // this makes all odd subsequence 
                oddnum++;

            }
        }

        int parity=nums[0]%2;
        


        for(int i=1;i<nums.length;i++){
            if(nums[i]%2!=parity){
                 parity=nums[i]%2;
                alternum++;
            }
            
        }


        return Math.max(Math.max(oddnum,evennum),alternum);

    }

}