class Solution {

    // using the HashMap to stre the unique element in the sum , without this we cannot  do the distinct sum 
    public int minLength(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        int left = 0;
        long distinctSum = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];

            freq.put(val, freq.getOrDefault(val, 0) + 1);

            if (freq.get(val) == 1) {
                distinctSum += val;
            }

            while (distinctSum >= k) {
                ans = Math.min(ans, i - left + 1); // i means right ,just consider

                int remove = nums[left];
                freq.put(remove, freq.get(remove) - 1);

                if (freq.get(remove) == 0) {
                    distinctSum -= remove;

                }

                left++;

            }

        }

        return ans == Integer.MAX_VALUE ? -1 : ans;

      }



   

   // this code passes the test case 932/1048 only, because in this code i doesnt take distinct sum 
    // public int minLength(int[] nums, int k) {


    //     HashSet<Integer>set=new HashSet<>();
        

    //     int n = nums.length;

    //     int i = 0;

    //     int sum = 0;

    //     int ans = Integer.MAX_VALUE;

    //     for (int j = 0; j < n; j++) {
    //         sum += nums[j];

    //         while (sum >=k && i <= j) {
    //             ans = Math.min(ans, j - i + 1);

    //             sum -= nums[i];

    //             i++;
    //         }

    //     }

    //     return ans==Integer.MAX_VALUE?-1:ans;
    // }
}