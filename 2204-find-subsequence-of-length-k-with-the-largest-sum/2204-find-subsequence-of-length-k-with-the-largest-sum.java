 class Solution 
{
    public int[] maxSubsequence(int[] nums, int k) 
    {
        int n = nums.length;

        // Step 1: Pair elements with indices
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) 
        {
            pairs[i][0] = nums[i]; // value
            pairs[i][1] = i;        // index
        }

        // Step 2: Sort by value descending
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        // Step 3: Take top k elements
        Arrays.sort(pairs, 0, k, Comparator.comparingInt(a -> a[1]));

        // Step 4: Extract the values in original order
        int[] result = new int[k];
        for (int i = 0; i < k; i++) 
        {
            result[i] = pairs[i][0];
        }

        // Step 5: Return the subsequence
        return result;
    }
}