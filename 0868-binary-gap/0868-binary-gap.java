class Solution {
    public int binaryGap(int n) {

        //simple and brute force , and easy to do , without the Bitwise 
        String Binary=Integer.toBinaryString(n);

        int max=0;

        for(int i=0;i<Binary.length();i++){
            for(int j=i+1;j<Binary.length();j++){
                if(Binary.charAt(i)=='1' && Binary.charAt(j)=='1'){
                   int count=j-i;

                    max=Math.max(max,count);
                    break;
                }
            }
        }

        return max;

    }


  //100 % accepted
    //  public int binaryGap(int n) {
    //     int max=0;
    //     int prev=-1;
    //     int next=0;
    //     while(n>0){
    //         if((n&1)==1){
    //             if(prev!=-1){
    //                 max=Math.max(max,next-prev);
                    
    //             }
    //             prev=next;
    //         }
    //           n >>= 1;
    //           next++;
    //     }
    //     return max;
    // }
}