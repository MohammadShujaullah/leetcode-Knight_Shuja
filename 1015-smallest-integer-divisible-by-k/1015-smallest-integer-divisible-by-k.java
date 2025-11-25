class Solution {
    // the remainder , is 0,1,2,...k,   after the length of k, 
    //their is no change of getting the answer ,
    // under the lenght of k, the raminder //can be zero  and if 
    //not then it never will be zero , sop till length of K
    public int smallestRepunitDivByK(int k) {
        int n = 0;
        int temp = 0;

  

        for (int i = 1; i <= k; i++) {
            temp = (temp * 10 + 1) % k;
            n++;

            if (temp == 0) {
                break;
            }
        }


        if(temp!=0){
            return -1;
        }

        return n;

    }
}