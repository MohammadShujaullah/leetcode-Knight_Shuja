class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int n=-1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                n=i;
                max=arr[i];
            }
        }
        return n;
    }
}