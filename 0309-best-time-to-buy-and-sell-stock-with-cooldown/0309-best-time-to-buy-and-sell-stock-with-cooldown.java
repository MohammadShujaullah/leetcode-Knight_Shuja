class Solution {
    // public int maxProfit(int[] prices) {
    //     int smallest = Integer.MAX_VALUE;
    //     int currprofit = 0;
    //     int sum = 0;
    //     int maxprofit = 0;

    //     for (int i = 0; i < prices.length; i++) {
    //         if (prices[i] < smallest) {
    //             smallest = prices[i];
    //         }
    //         currprofit = prices[i] - smallest;

    //         if (currprofit > 0) {
    //             i++;

    //         }
    //         sum += currprofit;
    //         maxprofit = Math.max(sum, maxprofit);

    //     }

    //     return sum;
    // }
    //-------------------------------passes the 71/210 -----using same code of 121 question    

    int n;
    int t[][];

    private int solve(int day, int[] prices, boolean buy) {
        if (day >= n) {
            return 0;
        }
        int flag = 0;
        if (buy) {
            flag = 1;
        } else {
            flag = 0;
        }

        if (t[day][flag] != -1) {
            return t[day][flag];
        }

        int profit = 0;

        if (buy) {//buy

            /*finding profit*/
            int take = solve(day + 1, prices, false) - prices[day]; // selling -current buy gives, profit

            int not_take = solve(day + 1, prices, true); // age jaakr bhi to buy krna hoga hi

            profit = Math.max(profit, Math.max(take, not_take));

        } else {//sell
            int sell = prices[day] + solve(day + 2, prices, true); //after taking sell of the day, main buy krne jaunga , but after 1 day cooldown

            int not_sell = solve(day + 1, prices, false); // agr abhi nahi sell kia to ,aage to sell krna hi hoga 
            profit = Math.max(profit, Math.max(sell, not_sell));

        }

        return t[day][flag] = profit;

    }

    public int maxProfit(int[] prices) {

        n = prices.length;
        t = new int[n + 1][2];

        for (int row[] : t) {
            Arrays.fill(row, -1);
        }
        boolean buy = true;
        return solve(0, prices, buy);

    }
}