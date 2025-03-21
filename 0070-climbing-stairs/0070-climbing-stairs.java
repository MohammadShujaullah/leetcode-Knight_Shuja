class Solution {
    private int solve(int dp[],int n){
         if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n]=solve(dp,n-1)+solve(dp,n-2);

    }
    public int climbStairs(int n) {
        // firstly we do ,with brute force approch
        // by memoization
        // by bottom up approch

       
        int dp[]=new int [n+1];
        Arrays.fill(dp,-1);


        return solve(dp,n);

    }
}