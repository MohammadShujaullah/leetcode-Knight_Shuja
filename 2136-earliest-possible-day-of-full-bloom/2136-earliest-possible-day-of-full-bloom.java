class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;

        int vec[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            vec[i][0] = plantTime[i];
            vec[i][1] = growTime[i];

        }

        Arrays.sort(vec, (a, b) -> b[1] - a[1]);

        int prevPlantTime = 0;
        int maxBloom = 0;

        for (int i = 0; i < n; i++) {
            int currplant = vec[i][0];

            int currgrow = vec[i][1];

            prevPlantTime += currplant;

            int currbloom = prevPlantTime + currgrow;

            maxBloom = Math.max(maxBloom, currbloom);

        }

        return maxBloom;

    }
}