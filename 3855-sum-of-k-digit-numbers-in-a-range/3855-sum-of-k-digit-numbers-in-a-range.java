class Solution {

    private static final long MOD=1_000_000_007L;
    public int sumOfNumbers(int l, int r, int k) {
        long n=r-l+1;
        long sumofrange=(long)(l+r)*n/2;
        sumofrange%=MOD;

        long conb=power(n,(long)k-1);

        long tem=(power(10,(long)k)-1+MOD)%MOD;

        long sum=(tem*modInverse(9)%MOD);

        long totalsum=(sumofrange*conb)%MOD;
        totalsum=(totalsum*sum)%MOD;
        return (int)totalsum;
        
        
    }

    private long power(long base,long exp){
        long res=1;
        base%=MOD;
        while(exp>0){
            if(exp%2==1)res=(res*base)%MOD;
            base=(base*base)%MOD;
            exp/=2;
            
        }

        return res;
       
    }

     private long modInverse(long n){
         return power(n,MOD-2);
     }
}