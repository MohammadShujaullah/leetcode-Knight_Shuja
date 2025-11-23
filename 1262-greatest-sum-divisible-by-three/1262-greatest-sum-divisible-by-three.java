class Solution {
    // we have to know the concept that num%3  always gives 0,1,2 only , if r=2, 
    //

    // this method only pass 22/43 test cases
    // public int maxSumDivThree(int[] nums) {

    //     int Tsum = 0;
    //     for (int x : nums) {
    //         Tsum += x;
    //     }
    //     Arrays.sort(nums);

    //     int maxsum = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         if ((Tsum - nums[i]) % 3 == 0) {
    //             maxsum = Math.max(maxsum, (Tsum - nums[i]));

    //         }
    //     }

    //     return maxsum;
    // }

    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        List<Integer> remain1 = new ArrayList<>();
        List<Integer> remain2 = new ArrayList<>();

        for (int num : nums) {
            sum += num;

            if (num % 3 == 1)
                remain1.add(num);
            else if (num % 3 == 2)
                remain2.add(num);
        }

        if (sum % 3 == 0)
            return sum;

        Collections.sort(remain1);
        Collections.sort(remain2);

        int result = 0;

        if (sum % 3 == 1) {
            int remove1 = remain1.size() >= 1 ? remain1.get(0) : Integer.MAX_VALUE;
            int remove2 = remain2.size() >= 2 ? remain2.get(0) + remain2.get(1) : Integer.MAX_VALUE;
            result = sum - Math.min(remove1, remove2);
        } else { // sum % 3 == 2
            int remove1 = remain2.size() >= 1 ? remain2.get(0) : Integer.MAX_VALUE;
            int remove2 = remain1.size() >= 2 ? remain1.get(0) + remain1.get(1) : Integer.MAX_VALUE;
            result = sum - Math.min(remove1, remove2);
        }

        return Math.max(result, 0);
    }

}