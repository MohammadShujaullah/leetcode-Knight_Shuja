class Solution {
    public boolean isPowerOfThree(int n) {

        // if (n == 0)
        //     return false;
        // while (n %3==0) {             // time complexity will O(log3^n)
 
        //     n = n / 3;
        // }
        // return n==1;
        //------------------------------------------------------

        // boolean check(int n){
        //     if(n<=0)return false;      //time complexity will O(log3^n)
        //     if(n==1){                        //space complexity will O(Log n^3)
        //         return true;

        //     }
        //     if(n%3!=0)return false;

        //     return check(n/3);

        // }
        //----------------------------------------------------------

        //taking log on both side and then find only the value of x ,as it must be avalid int , so that n will be a power of 3
        //  if(n<=0)return false; 
        // double x = Math.log10(n) / Math.log10(3);
        // return x == (int) x;
        
        //----------------------------------------------------------
        return n>0 &&  1162261467%n==0;


    }
}