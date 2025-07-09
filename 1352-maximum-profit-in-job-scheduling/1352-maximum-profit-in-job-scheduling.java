class Solution {
    int n;
    //2 element are changing ,so take 2D dp
    int DP[];

    private int solve(int idx, int[][] events) {
        if (idx == events.length) {
            return 0;
        }

        if (DP[idx] != -1) {
            return DP[idx];
        }

        //inplace of linear search we use binary search ,
        // Binary Search to find the next non-overlapping event
        int low = idx + 1, high = n;
        int next = n;
        while (low < high) {
            int mid = (low + high) / 2;
            if (events[mid][0] >= events[idx][1]) {
                next = mid;
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int take = events[idx][2] + solve(next, events);
        int skip = solve(idx + 1, events);
        return DP[idx] = Math.max(take, skip);
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        // making a 2D array , to store each job with their profit at one place
        int events[][] = new int[startTime.length][3];

        for (int i = 0; i < events.length; i++) {
            events[i][0] = startTime[i];
            events[i][1] = endTime[i];

            events[i][2] = profit[i];

        }
        n = events.length;
        DP = new int[n + 1];
        Arrays.fill(DP, -1);

        

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        return solve(0, events);
    }
}