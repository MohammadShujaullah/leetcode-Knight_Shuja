 import java.util.*;

class Solution {
    public long getCost(int[] nums, int[] cost, int target) {
        long result = 0;
        for (int i = 0; i < nums.length; ++i) {
            result += (long) Math.abs(nums[i] - target) * cost[i];
        }
        return result;
    }

    public long minCost(int[] nums, int[] cost) {
        long answer = Long.MAX_VALUE;

        int left = Arrays.stream(nums).min().getAsInt();  // Minimum value in nums
        int right = Arrays.stream(nums).max().getAsInt(); // Maximum value in nums

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long cost1 = getCost(nums, cost, mid);
            long cost2 = getCost(nums, cost, mid + 1);

            answer = Math.min(cost1, cost2);
            if (cost1 > cost2) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer == Long.MAX_VALUE ? 0 : answer;
    }
}
