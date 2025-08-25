class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0)
            return result;

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int left = 0;
        int bottom = m - 1;
        int right = n - 1;

        int dir = 0; // direction 

        /*
        ther are all 4 direction
        dir=0;    // left to right
        dir=1;    // top to bottom
        dir=2;     // right to left
        dir=3;    // bottom to top  
        */

        // now commin on printing the result 
        while (top <= bottom && left <= right) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);

                }
                top++;
            }

            if (dir == 1) {
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);

                }
                right--;

            }

            if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);

                }
                bottom--;
            }

            if (dir == 3) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);

                }
                left++;
            }

            dir += 1;
            if (dir == 4) {
                dir = 0;
            }
        }

        return result;

    }
}