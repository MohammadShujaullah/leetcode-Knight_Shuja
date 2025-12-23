class Solution {
      int n;
    //2 element are changing ,so take 2D dp
    int DP[][];

     private int solve(int idx, int[][] events, int k) {
        if (idx >= events.length || k <= 0) {
            return 0;
        }

        if (DP[idx][k] != -1) {
            return DP[idx][k];
        }

        //inplace of linear search we use binary search ,
        // Binary Search to find the next non-overlapping event
        int low = idx + 1, high = n;
        int next = n;
        while (low < high) {
            int mid = (low + high) / 2;
            if (events[mid][0] > events[idx][1]) {      // binary search se kaise ham nikaal pa rhe ha, kyunke events sorted ha
                next = mid;
                high = mid;
            } else {
                low = mid + 1;                         // yaani mid answer nahi hoskta ha, so we go , mid ke left pr 
            }
        }

        int take = events[idx][2] + solve(next, events, k - 1);
        int skip = solve(idx + 1, events, k);
        return DP[idx][k] = Math.max(take, skip);
    }
    public int maxTwoEvents(int[][] events) {
         n = events.length;

          DP = new int[n + 1][2 + 1];    // two is maximum two non-overlaping

        for (int i = 0; i <= n; i++) {
            Arrays.fill(DP[i], -1);

        }
          Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
             return solve(0, events, 2);           // two is maximum two non-overlaping
    }
}