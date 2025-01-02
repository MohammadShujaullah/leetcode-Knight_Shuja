// in this example we use binary search generally, but we also use little trick
// also because it has sorted order matrix 

//in this question the key concept is to convert the ,1D array index to 2D array index
// such as  in 1D mid=8,  so in 2D its index will be [mid/clmn][mid%clmn]

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m * n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (matrix[mid / n][mid % n] > target) { // means answer will lie at leftside
                end = mid - 1;

            } else if (matrix[mid / n][mid % n] < target) {  // means answer will lie at rightside
                start = mid + 1;

            }
            else{
                return true;
            }
        }
        return false;    // if target is not found
    }
}