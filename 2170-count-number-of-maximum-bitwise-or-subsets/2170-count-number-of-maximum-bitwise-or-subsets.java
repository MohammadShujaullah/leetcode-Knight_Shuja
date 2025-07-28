class Solution {
    int n;
    int t[][];

    private int countSubsets(int idx, int[] nums, int curror, int maxor) {
        if (idx == n) {
            if (curror == maxor) {
                return 1;
            }
            return 0;
        }

        // if(t[idx][curror]!=-1){
        //     return t[idx][curror];

        // }

        int takecount = countSubsets(idx + 1, nums, curror | nums[idx], maxor);
        int skipcount = countSubsets(idx + 1, nums, curror, maxor);

        return  takecount + skipcount;
    }

    public int countMaxOrSubsets(int[] nums) {
        n = nums.length;
        int maxor = 0;
        for (int n : nums) {
            maxor = maxor | n;
        }
        t = new int[n + 1][maxor + 1];


        for (int row[] : t) {
            Arrays.fill(row, -1);
        }

        int curror = 0;
        return countSubsets(0, nums, curror, maxor);
    }
}
