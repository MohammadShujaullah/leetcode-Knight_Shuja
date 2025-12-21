class Solution {
    public int minimumLevels(int[] possible) {
        int prefsum[] = new int[possible.length];

        if (possible[0] == 0) {
            possible[0] = -1;
            prefsum[0] = possible[0];
        } else {

            prefsum[0] = possible[0];

        }

        for (int i = 1; i < possible.length; i++) {

            if (possible[i] == 0) {
                possible[i] = -1;
            }
            prefsum[i] = possible[i] + prefsum[i - 1];

        }

        int count = 0;
        int mincount = Integer.MAX_VALUE;

        for (int i = 0; i < prefsum.length; i++) {
            if (prefsum[i] > (prefsum[prefsum.length - 1] - prefsum[i])  && i!=prefsum.length - 1) {
                count =i+1;
                mincount = Math.min(count, mincount);

            }
        }

        if (mincount == Integer.MAX_VALUE) {
            return -1;
        }

        return mincount;
    }
}