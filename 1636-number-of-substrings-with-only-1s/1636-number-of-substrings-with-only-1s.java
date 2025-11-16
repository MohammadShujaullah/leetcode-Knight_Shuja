class Solution {
    public int numSub(String s) {
        int n=s.length();
         long count=0;
         long result=0;
         int mod=1000000007;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
               count++;
            }
            else{
                  result+=(count*(count+1)/2)%mod;
                  count=0;

            }
        }

        result+=(count*(count+1)/2)%mod;

        return (int)result%mod;
    }
}