class Solution {
    // without memoization ,the code giving me TLE,so use Memo


    // int t[];

    // private int solve(int[] nums, int i, int n) {     // top down approch.
    //     if (i >= nums.length) {
    //         return 0;
    //     }

    //     if (t[i] != -1)
    //         return t[i];

    //     int steal = nums[i] + solve(nums, i + 2, n);
    //     int skip = solve(nums, i + 1, n);

    //     return t[i] = Math.max(steal, skip);

    // }

    public int rob(int[] nums) {


        // Bottom up approch 
       int n= nums.length;
       if(n==1){
        return nums[0];

       }

       int t[]=new int [n+1];
       // t[i]  is   max. stolen money till i house 

       // no house 
       t[0]=0;

       // 1 house 
       t[1]=nums[0];
       for(int i=2;i<=n;i++){
        int steal=nums[i-1]+t[i-2];
        int skip=t[i-1];

        t[i]=Math.max(steal,skip);

       }
       return t[n];
 
    }
}