class Solution {
    private void solveright(int height[], int right[]) {
        int n=height.length;
     right[n-1]=height[n-1];

        for (int i = height.length - 2; i >= 0; i--) {

          right[i]=Math.max(right[i+1],height[i]);

        }
    }

    private void solveleft(int height[], int left[]) {
       left[0]=height[0];


        for (int i = 1; i < height.length; i++) {
          left[i]=Math.max(left[i-1],height[i]);
   
        }
    }

    public int trap(int[] height) {
        int left[] = new int[height.length];
        int right[] = new int[height.length];

        solveleft(height, left);

        solveright(height, right);

        int count = 0;

        for (int i = 0; i < height.length; i++) {
           count+=Math.min(left[i],right[i])-height[i];

        }

        return count;

    }
}