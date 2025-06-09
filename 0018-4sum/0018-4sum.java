 class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // Return empty list if the input array has fewer than 4 elements
        if (nums.length < 4) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        // Sort the array to apply the two-pointer technique
        Arrays.sort(nums);
        int size = nums.length;

        // First loop to fix the first element
        for (int i = 0; i < size; i++) {
            // Skip duplicate elements to avoid repeated quadruplets
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            // Second loop to fix the second element
            for (int j = i + 1; j < size; j++) {
                // Skip duplicate elements to avoid repeated quadruplets
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // Initialize two pointers: k and l
                int k = j + 1;
                int l = size - 1;

                // Two-pointer approach to find the remaining two elements
                while (k < l) {
                    // Calculate the sum of the four elements
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        // Add the quadruplet to the result list if the sum matches the target
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        // Skip duplicates for the third element
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }

                        // Skip duplicates for the fourth element
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    } else if (sum < target) {
                        // If sum is less than the target, move the left pointer k forward
                        k++;
                    } else {
                        // If sum is greater than the target, move the right pointer l backward
                        l--;
                    }
                }
            }

        }

        return result;
    }
}