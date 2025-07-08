import java.util.*;

class Solution {
    int n;
    int[][] dp;

    public int solve(int[][] events, int i, int k) {
        if (k <= 0 || i >= n)
            return 0;

        if (dp[i][k] != -1)
            return dp[i][k];

        int start = events[i][0];
        int end = events[i][1];
        int value = events[i][2];

        // find the next event index where start time > end time of current event
        int nextIndex = upperBound(events, end);

        int take = value + solve(events, nextIndex, k - 1);
        int skip = solve(events, i + 1, k);

        return dp[i][k] = Math.max(take, skip);
    }

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        n = events.length;
        dp = new int[n + 1][k + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(events, 0, k);
    }

    // Helper function to perform upper_bound manually
    private int upperBound(int[][] events, int targetEnd) {
        int left = 0, right = n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] <= targetEnd)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
