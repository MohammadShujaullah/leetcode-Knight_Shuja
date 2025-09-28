class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int n=nums.length;
        double maxavg=0;

        double sum=0;

        for(int i=0;i<k;i++){
            sum+=nums[i];

        }

        maxavg=sum/k;

       //n-k is no. of windows
        for(int i=1;i<=n-k;i++){
            sum+=nums[k+i-1];
            sum-=nums[i-1];
            maxavg=Math.max(maxavg,sum/k);

        }

        return maxavg;

    }
}