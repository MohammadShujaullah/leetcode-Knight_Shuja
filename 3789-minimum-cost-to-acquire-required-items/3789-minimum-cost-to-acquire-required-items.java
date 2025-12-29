class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if (need1 == 0 && need2 == 0)
            return 0;

        long priceForBoth = Math.min(costBoth, (long) cost1 + cost2);

        long priceForOnly1 = Math.min(cost1, costBoth);
        long priceForOnly2 = Math.min(cost2, costBoth);

        long totalcost = 0;

        long common = Math.min(need1, need2);

        totalcost += common * priceForBoth;

        if (need1 > need2) {
            totalcost += (long) (need1 - common) * priceForOnly1;

        } else if (need2 > need1) {
            totalcost += (long) (need2 - common) * priceForOnly2;

        }

        return totalcost;

    }
    
    
}