class Solution {
    public int minCost(String colors, int[] neededTime) {

        int j = 1;
        int res = 0;
        int max=neededTime[0];

        for (int i = 0; i < colors.length()-1; i++) {

            char ch = colors.charAt(i);
            if (colors.charAt(j) == ch) {
                res+= Math.min(max, neededTime[j]);

                max=Math.max(max, neededTime[j]);


            }
            else{
                max=neededTime[j];
            }
            j++;
        }

        return res;

    }
}