class Solution {

    // we have to track of maximum element at left side and right side , and then take minimum of it ,
    // then take diffrence with the element , to find the hieght of that element 

    // you can also see diffrent method to find the left and right max from chatGPT(max element approch )




    private void findMax1(int leftArr[], int height[]) {

        leftArr[0] = height[0]; // first ewlement always as max of their left 

        for (int i = 1; i < height.length; i++) {
            leftArr[i] = Math.max(leftArr[i - 1], height[i]);

        }

    }

    private void findMax2(int rightArr[], int height[]) {
        int n = height.length;

        rightArr[n - 1] = height[n - 1]; // last element always as max of their right

        for (int i = n - 2; i >= 0; i--) {
            rightArr[i] = Math.max(rightArr[i + 1], height[i]);

        }

    }

    public int trap(int[] height) {
        int n = height.length;

        int rightArr[] = new int[n];
        int leftArr[] = new int[n];

        findMax2(rightArr, height);
        findMax1(leftArr, height);

        int sum = 0;

        for (int i = 0; i < n; i++) {
            int h = Math.min(rightArr[i], leftArr[i]) - height[i];

            sum += h;

        }

        return sum;

    }
}