class Solution {// you should use the hashmap to make the time complexity to O(n)

    private int getdigitSum(int num) {
        int sum = 0;
        int n = num;

        while (n > 0) {
            sum += n % 10;

            n = n / 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {

        HashMap<Integer, Integer> mp = new HashMap<>(); // sum,num
        int sum =0;
        int maxesum = -1;
        for (int num : nums) {
             sum = getdigitSum(num);

            // if another number with same number sum exist ,then update the maxesum
            if (mp.containsKey(sum)) {
                maxesum = Math.max(maxesum, mp.get(sum) + num);

            }

            // **update the maximum number for this digit sum**
            /* v.v.i line */
            mp.put(sum, Math.max(mp.getOrDefault(sum, 0), num));

        }

        return maxesum;
    }
}