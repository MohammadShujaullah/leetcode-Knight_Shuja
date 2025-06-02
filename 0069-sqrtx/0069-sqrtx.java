class Solution {
    public int mySqrt(int x) {       /// space O(1) and time=O(n)
        int left=1;
        int right=x;
        int ans=0;
        if(x==0 ||x==1) return x;


        while(left<=right){

            int mid=left+(right-left)/2;

            if(mid*mid==x){
                return mid;
            }

            else if((long)mid*mid<(long)x){
                left=mid+1;
                ans=mid;

            }
            else{
                right=mid-1;

            }
            
        }

        return Math.round(ans);
    }
}