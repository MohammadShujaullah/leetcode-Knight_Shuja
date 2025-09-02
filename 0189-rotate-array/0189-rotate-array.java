class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k=k%n;

        int arr[] = new int[k];
        int j = 0;
     
           for (int i = n - k; i < n; i++) {
            arr[j] = nums[i];
            j++;
           }
       
        
        int m=n-k;
        int p=n-1;

        while(m-1>=0){
           nums[p]=nums[m-1];
           m--;
           p--;
           
        }
        for(int i=0;i<arr.length;i++){
             nums[i]=arr[i];
        }

    }
}