class Solution {
    //public void rotate(int[] nums, int k) {
    // int n = nums.length;
    // k=k%n;              /// important step when rotation is greater than the size

    // int arr[] = new int[k];
    // int j = 0;

    //    for (int i = n - k; i < n; i++) {
    //     arr[j] = nums[i];
    //     j++;
    //    }

    // int m=n-k;
    // int p=n-1;

    // while(m-1>=0){
    //    nums[p]=nums[m-1];
    //    m--;
    //    p--;

    // }
    // for(int i=0;i<arr.length;i++){
    //      nums[i]=arr[i];
    // }
    //}

    //------------Brute force ----with extra space -------O(n)----------------

    private void  reverse(int nums[], int k , int i, int j) {

        // first sections reverse

        while (i <= j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        

    }

    public void rotate(int[] nums, int k) {
         int n = nums.length;
        k = k % n; /// important step when rotation is greater than the size
       
        reverse(nums, k, 0, n - k - 1);
        reverse(nums, k, n - k, n - 1);
        reverse(nums, k, 0, n - 1);

    }

}