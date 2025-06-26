class Solution {
    // int n;
    // private int solve(String s,int k,int i){
        
    //     if(i<0)return 0;
    //     int bit=s.charAt(i)-'0';    // char to integer

    //     long num=(bit==1)?(long)Math.pow(2,n-i-1):0;
        
    //     int take=0;
    //     if(num<=k){
    //        take=1+solve(s,(int)(k-num),i-1);
    //     }
    //     int skip=solve(s,k,i-1);

    // return Math.max(skip,take);
    


    // }

    public int longestSubsequence(String s, int k) {
        int n = s.length();
        // return solve(s, k, n - 1);

        int count=0;
        for(int i=n-1;i>=0;i--){
            int bit=s.charAt(i)-'0';
                
            long num=(bit==1)?(long)Math.pow(2,n-i-1):0;
            if(num<=k){
              count++;
              k-=num;
            }
                   
                   
        }
        return count;
    }
}