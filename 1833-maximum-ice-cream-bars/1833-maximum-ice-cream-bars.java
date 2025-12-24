class Solution {
    public int maxIceCream(int[] costs, int coins) {

        Arrays.sort(costs);
        int count = 0;
        int currcost = 0;

        for (int i = 0; i < costs.length; i++) {
            if (coins > costs[i]) {
                currcost += costs[i];
                count++;
            }

            if (currcost >= coins) {
                break;

            }
        }


        if(currcost>coins){
            return count-=1;
        }

        return count;
    }
}