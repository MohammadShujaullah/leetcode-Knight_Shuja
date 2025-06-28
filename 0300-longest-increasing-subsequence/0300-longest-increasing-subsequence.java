class Solution{
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int t[] = new int[n];
        Arrays.fill(t, 1); // initially all the element has its own subsequence , which is itself
        int maxLIS=1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]  ) { // second condition is , that if mere piich wala subsequence bda ha ,to for main update krunga , lekin agr mera kud ka subsequnce bda ha to kyun update krunga
                   t[i]=Math.max(t[i],t[j]+1);
                   maxLIS=Math.max( maxLIS,t[i]);

                }
            }
        }

        return  maxLIS;
    }
}