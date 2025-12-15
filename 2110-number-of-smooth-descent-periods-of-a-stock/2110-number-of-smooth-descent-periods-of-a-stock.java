class Solution {
    // we just counting the number which is decreasing by one , then we add the it to the ans ,
    // as till the ith element the numebr of the count,
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long ans = 1;
        int count = 1;
        
        for (int i = 1; i < n; i++) {
            if (prices[i-1] - prices[i] == 1) {
                 count+=1;

            }
            else{
                count=1;

            }
            ans+=count;
        }

        return ans;

    }
}