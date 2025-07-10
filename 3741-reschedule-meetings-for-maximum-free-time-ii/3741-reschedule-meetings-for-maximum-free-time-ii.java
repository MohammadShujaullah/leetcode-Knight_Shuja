class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n + 1];

        // Compute initial free time gaps
        gaps[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[n] = eventTime - endTime[n - 1];

        int N = gaps.length;

        int maxRightFree[] = new int[N];
        int maxLeftFree[] = new int[N];

        // now fill the  maxRightFree[]
        for (int i = N - 2; i >= 0; i--) {
            maxRightFree[i] = Math.max(maxRightFree[i + 1], gaps[i + 1]);
        }

        //now fill the maxLeftfree
        for (int i = 1; i < N; i++) {
           maxLeftFree[i] = Math.max(maxLeftFree[i - 1], gaps[i - 1]);
        }
        int result = 0;

        // iterate over gaps
        for (int i = 1; i < N; i++) {
            // duration d
            int currentEventTime = endTime[i - 1] - startTime[i - 1];


            //case 1. Moving Completely out 
            if(currentEventTime<=Math.max(maxLeftFree[i - 1], maxRightFree[i])){
                result=Math.max(result,gaps[i-1]+gaps[i]+currentEventTime);
            }

            //case 2 Shift left or right in adjacent 

            result=Math.max(result,gaps[i-1]+gaps[i]);
        }

        //case 1. when we dont reschedule any event, and just find the maximum free time 

        // cas2, when we move an event , and completly form a gap, inplace of it

        // case3, when we just shift the event to its ajacent ,either left or right
       

        return result;
        
    }
}