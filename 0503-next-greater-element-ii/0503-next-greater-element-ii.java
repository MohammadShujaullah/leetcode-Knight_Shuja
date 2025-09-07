class Solution {

    /**WHENEVER there is circular arr, do nothing more! just create a newarr with size double 
    of the original arr and just copy the original arr twice in the newarr, so we can do the 
    circular arr traversal in single loop, no back pointer, EASY! this question can be easily 
    solved without stack, by the above-mentioned approach! */

    //-----------------Brute force O(n2)--------------------- by just traversing on nums double time ----//
    // public int[] nextGreaterElements(int[] nums) {
    //     int n=nums.length;
    //     int ans[]=new int [n];
    //     Arrays.fill(ans,Integer.MIN_VALUE);

    //     for(int i=0;i<n;i++){
    //         for(int j=i+1;j<=i+n-1;j++){
    //             if(nums[i]<nums[j%n]){
    //                 ans[i]=nums[j%n];
    //                 break;
    //             }
    //         }
    //         if(ans[i]==Integer.MIN_VALUE){
    //             ans[i]=-1;
    //         }
    //     }

    //     return ans;

    // }

    /////////////--------------------O(4n)=O(2n*2)  , as pushing and poping element takes 2 times   
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) { // as you double the array hypothetically, then the last inx is tarted from 2*n-1
            while (!st.isEmpty() && nums[i % n] >= st.peek()) {
                st.pop();

            }

            // but just after i<n, you have to store the next greater in ans[]

            if (i < n) {
                ans[i] = (st.size() > 0 ? st.peek() : -1);

            }
            st.push(nums[i%n]);

        }
        return ans;

    }

}