class Solution {
    private long findCost(int[] nums, int[] cost, int target) {
        long result = 0;

        for (int j = 0; j < nums.length; j++) {
            result += (long)(Math.abs(target - nums[j])) * cost[j];
        }
        return result;
    }

    public long minCost(int[] nums, int[] cost) {
        long answer = Long.MAX_VALUE;
        int l = Arrays.stream(nums).min().getAsInt();
        int r = Arrays.stream(nums).max().getAsInt();
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long cost1 = findCost(nums, cost, mid);
            long cost2 = findCost(nums, cost, mid + 1);
            answer = Math.min(cost1, cost2);
            if (cost1 > cost2) {
                l = mid + 1;

            } else {
                r = mid - 1;
            }

        }
        return answer == Long.MAX_VALUE ? 0 : answer;

    }
}