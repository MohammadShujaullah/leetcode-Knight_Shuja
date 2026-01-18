class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int cx = center[0];
        int cy = center[1];

        int maxQuality = -1;
        int bestX = 0;
        int bestY = 0;

        for (int[] tower : towers) {
            int x = tower[0];
            int y = tower[1];
            int quality = tower[2];

            long manhattenDistance = Math.abs((long) x - cx) + Math.abs((long) y - cy);

            if (manhattenDistance <= radius) {

                if (maxQuality == -1) {
                    maxQuality = quality;
                    bestX = x;
                    bestY = y;
                }

                if (quality > maxQuality || (quality == maxQuality && (x < bestX || (x == bestX && y < bestY)))) {
                    maxQuality = quality;
                    bestX = x;
                    bestY = y;

                }

            }

        }

        if (maxQuality == -1) {
            return new int[] { -1, -1 };
        }

        return new int[] { bestX, bestY };
    }
}