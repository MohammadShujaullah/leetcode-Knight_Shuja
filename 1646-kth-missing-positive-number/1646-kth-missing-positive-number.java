class Solution {
    public int findKthPositive(int[] arr, int k) {
    int num=1;
      int i=0;
      int n=arr.length;
     while(i<n && k>0){
        if(arr[i]==num){
            i++;
        }else{
            k--;
        }
        num++;
     }
      while(k>0){   // still k is not equal to zero
        k--;
        num++;
      }
     return num-1;
    }
}