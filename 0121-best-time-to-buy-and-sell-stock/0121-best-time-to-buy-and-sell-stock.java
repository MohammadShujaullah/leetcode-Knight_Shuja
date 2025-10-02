class Solution {
    public int maxProfit(int[] prices) {
        //as this question is solved through brute force in O(n2) time ,, which is very simple 

        // but we can use Kadane algorithm in it forO(n) time 

        int maxprofit = 0; // as we have to find maxprofit at every element , and alsao check that ,is it a minprice or not 
        int minprice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            minprice = Math.min(minprice, prices[i]);

            maxprofit = Math.max(maxprofit, (prices[i] - minprice));

        }

        return maxprofit;

    }
}