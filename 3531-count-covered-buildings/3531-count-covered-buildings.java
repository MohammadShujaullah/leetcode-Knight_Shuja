// class pair1{
//     int f1;
//     int s1;

//     pbulic pair1(int f1,int s1){
//         this.f1=f1;
//         this.s1=s1;

//     }
// }
// class pair2{
//     int f2;
//     int s2;

//     pbulic pair2(int f2,int s2){
//         this.f2=f2;
//         this.s2=s2;

//     }
// }
import java.util.*;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, int[]> xMinMaxToY = new HashMap<>();
        Map<Integer, int[]> yMinMaxToX = new HashMap<>();

        for (int d[] : buildings) {
            int x = d[0];
            int y = d[1];

            
                xMinMaxToY.putIfAbsent(x, new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE });
            

            
                yMinMaxToX.putIfAbsent(y, new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE });
            

            int xr[] = yMinMaxToX.get(y);
            xr[0] = Math.min(xr[0], x);
            xr[1] = Math.max(xr[1], x);

            int yr[] = xMinMaxToY.get(x);
            yr[0] = Math.min(yr[0], y);
            yr[1] = Math.max(yr[1], y);

        }

        int result = 0;

        for (int d[] : buildings) {
            int x = d[0];
            int y = d[1];

            int yr[] = xMinMaxToY.get(x);

            int xr[] = yMinMaxToX.get(y);

            if (yr[0] < y && y < yr[1] && xr[0] < x && xr[1] > x) {
                result++;

            }

        }

        return result;

    }
}