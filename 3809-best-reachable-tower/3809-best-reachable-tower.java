class Solution {
    // public int[] bestTower(int[][] towers, int[] center, int radius) {
    //     int cx = center[0];
    //     int cy = center[1];

    //     int maxQuality = -1;
    //     int bestX = 0;
    //     int bestY = 0;

    //     for (int[] tower : towers) {
    //         int x = tower[0];
    //         int y = tower[1];
    //         int quality = tower[2];

    //         long manhattenDistance = Math.abs((long) x - cx) + Math.abs((long) y - cy);

    //         if (manhattenDistance <= radius) {

    //             if (maxQuality == -1) {
    //                 maxQuality = quality;
    //                 bestX = x;
    //                 bestY = y;
    //             }

    //             if (quality > maxQuality || (quality == maxQuality && (x < bestX || (x == bestX && y < bestY)))) {
    //                 maxQuality = quality;
    //                 bestX = x;
    //                 bestY = y;

    //             }

    //         }

    //     }

    //     if (maxQuality == -1) {
    //         return new int[] { -1, -1 };
    //     }

    //     return new int[] { bestX, bestY };
    // }

    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int cx = center[0];
        int cy = center[1];

        int maxq = -1;
        int bestx = 0;
        int besty = 0;

        for (int t[] : towers) {
            int x = t[0];
            int y = t[1];
            int q = t[2];

            int dist = Math.abs(cx - x) + Math.abs(cy - y);

            if (dist <= radius) {
                //reachable

                if (q > maxq) {
                    maxq = q;
                    bestx = x;
                    besty = y;

                } else if (q == maxq) {
                    if (bestx > x || (bestx == x && besty > y)) {
                        bestx = x;
                        besty = y;
                    }
                }
            }
        }

        if(maxq==-1){
            return new int[]{-1,-1};

        }

        return new int[]{bestx,besty};
    }
}