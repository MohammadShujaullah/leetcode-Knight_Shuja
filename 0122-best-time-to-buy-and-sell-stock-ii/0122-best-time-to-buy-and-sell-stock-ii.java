class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int currprofit = 0;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < smallest) {
                smallest = prices[i];

            }

            currprofit = prices[i] - smallest;
            smallest=prices[i];
            sum += currprofit;
        }

        return sum;
    }
}