class Solution {
    public boolean isPowerOfFour(int n) {
        // if (n <= 0)
        //     return false;

        // while (n % 4 == 0) {     // time cplexity=O(Log4^n)

        //     n = n / 4;

        // }

        // return n==1;

        //----------------------------------------
        //recursive approch is --------------

        // private boolean solve(int n){
        //     if(n==1)return true;
        //     if(n<=0) return false;            time O(Log4^n)
        //                                       spcae =O(Logn^4)

        //     if(n%4!=0)return false;

        //     return solve(n/4);

        // }

//---------------------------------- through log mathematical ----
      if(n<=0)return false;
       double x=Math.log10(n)/Math.log10(4);

       return x==(int)x;

    }
}