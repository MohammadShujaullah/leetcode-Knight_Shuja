class Solution {
    public int minSensors(int n, int m, int k) {
        int blocksize=2*k+1;
        int numsensorPerRow=(n+blocksize-1)/blocksize;

        int numsensorPerCol=(m+blocksize-1)/blocksize;


        return numsensorPerRow*numsensorPerCol;
        
    }
}