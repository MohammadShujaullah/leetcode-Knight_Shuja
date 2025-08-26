class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxdia = 0;
        int maxarea = 0;

        for (int x[] : dimensions) {
            double dia = Math.sqrt(x[0] * x[0] + x[1] * x[1]);
            int area = x[1] * x[0];

            if (dia > maxdia) {

                maxdia = dia;
                maxarea = area;
            } else if (dia == maxdia && area > maxarea) {
                maxarea = area;
            }

        }

        return maxarea;

    }
}