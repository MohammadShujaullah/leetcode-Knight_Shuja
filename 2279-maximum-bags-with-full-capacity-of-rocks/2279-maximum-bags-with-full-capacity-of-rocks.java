class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int temp[] = new int[rocks.length];

        for (int i = 0; i < rocks.length; i++) {
            temp[i] = capacity[i] - rocks[i];

        }

        Arrays.sort(temp);

        int i = 0;
        while (additionalRocks > 0 && i < rocks.length) {
            if (temp[i] != 0) {

                additionalRocks -= temp[i];

                if (additionalRocks >= 0) {
                    temp[i] = 0;
                }
                else{
                    temp[i]=-1;
                }

            }
            i++;
        }

        int count = 0;

        for (int x : temp) {
            if (x == 0) {
                count++;

            }
        }

        return count;

    }
}