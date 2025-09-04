class Solution {
    public void wiggleSort(int[] nums) {  // this solution is O(nlog(n))
        Arrays.sort(nums);
        int n=nums.length;

        int arr[]=new int [n];

        int i=1;
        int j=n-1;
        while(i<n){
            arr[i]=nums[j];
            i=i+2;
            j--;

        }
        i=0;
        while(i<n){
            arr[i]=nums[j];
            i=i+2;
            j--;
        }

        int x=0;
        while(x<n){
            nums[x]=arr[x];
            x++;
        }

    }
}