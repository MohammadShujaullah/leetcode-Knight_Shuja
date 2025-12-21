class Solution {
    // public List<List<Integer>> threeSum(int[] nums) {
    //     Set<List<Integer>> result = new HashSet<>();

    //     int target = 0;

    //     for (int i = 0; i <= nums.length - 3; i++) {

    //         int j = i + 1;

    //         while (j < nums.length) {
    //             int x = nums[i] + nums[j];

    //             for (int k = j + 1; k < nums.length; k++) {
    //                 if (nums[k] == target - x) {
    //                     ArrayList<Integer> l = new ArrayList<>();
    //                     l.add(nums[i]);
    //                     l.add(nums[j]);
    //                     l.add(nums[k]);
    //                     Collections.sort(l);  // its an important step , that if i sort the list then if duplicate list will come then , then it will not add in the result

    //                     result.add(l);

    //                 }

    //             }
    //             j++;
    //         }

    //     }
    //     return new ArrayList<>(result);

    ///------------------------brute force---- above ---------------//

    /// another solution 

    // public List<List<Integer>> threeSum(int[] nums) {
    //     Set<List<Integer>> result = new HashSet<>();
    //     Arrays.sort(nums); // sorting helps with duplicates

    //     for (int i = 0; i < nums.length - 2; i++) {
    //         int target = -nums[i];
    //         HashSet<Integer> seen = new HashSet<>();

    //         for (int j = i + 1; j < nums.length; j++) {
    //             int complement = target - nums[j];
    //             if (seen.contains(complement)) {
    //                 List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
    //                 Collections.sort(triplet);
    //                 result.add(triplet);
    //             }
    //             seen.add(nums[j]);
    //         }
    //     }

    //     return new ArrayList<>(result);

    //}

    // my understandable solution 
    //------- main concept of the question to solve is the -------/\-////\\\\\\\\\\\
    //  1.  sort the array , becuase we  have to return the element not index(like 2sum )
    // 2.  avoid the duplicate element
    // 3. avoid the duplicate target element becuase wwe find the triplet of it befor so why find it again 

  

   private void twoSum(int[] nums, int k, List<List<Integer>> result, int target) {
        int i = k, j = nums.length - 1;

        while (i < j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                result.add(Arrays.asList(-target, nums[i], nums[j]));

                while (i < j && nums[i] == nums[i + 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j - 1]) {
                    j--;
                }

                i++;
                j--;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
          List<List<Integer>> result=new ArrayList<>();
        int n = nums.length;

        if (n < 3)
            return new ArrayList<>();

        Arrays.sort(nums);

        // fixed one element 

        // i go till n-3

        for (int i = 0; i <= n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

         
          twoSum(nums, i + 1, result, -nums[i]); // it will find n2,n3 {n1,n2,n3}

        }


        return result;
    }
}