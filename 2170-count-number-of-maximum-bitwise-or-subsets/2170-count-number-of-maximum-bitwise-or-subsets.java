class Solution {
    int n;
    private int countSubsets(int idx, int[] nums, int curror, int maxor) {
        if (idx == n) {
            if (curror == maxor) {
                return 1; /// mughe ek subsequence mila jo , satisfy kr rjha h

            }

            return 0;
        }

        int takecount = countSubsets(idx + 1, nums, curror | nums[idx], maxor);
        int skipcount = countSubsets(idx + 1, nums, curror, maxor);

        return takecount + skipcount;

    }

    public int countMaxOrSubsets(int[] nums) {
        n=nums.length;
        int maxor = 0;
        for (int i = 0; i < nums.length; i++) {
            maxor = maxor | nums[i];
        }
        int curror = 0;

        return countSubsets(0, nums, curror, maxor);

    }
}