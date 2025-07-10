class Solution {

    // very simple solution, as we want a subarray which has size of n+1,contains no. of free times ,

    // according to observation, if we make k shifts, we get , then k+1 free time can be merge
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n + 1];

        // Compute initial free time gaps
        gaps[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[n] = eventTime - endTime[n - 1];

        // Sort gaps in descending order to prioritize larger gaps
        // Arrays.sort(gaps);

        // int maxFreeTime = 0;
        // for (int i = 0; i <= k; i++) {
        //     maxFreeTime += gaps[n - i];
        // }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i <=(n+1)-(k+1); i++) {
             sum=0;
            for (int j = i; j < k + i + 1; j++) {
                sum += gaps[j];
            }
            max = Math.max(sum, max);
        }

        return max;

    }
}